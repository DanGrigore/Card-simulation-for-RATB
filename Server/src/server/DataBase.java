package server;

import models.Card;
import models.Client;

import java.sql.*;

public class DataBase {
    private Connection myConn;
    private static DataBase db_instance = null;

    private DataBase() {
        final String DB_URL = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2237743";
        final String DB_USER = "sql2237743";
        final String DB_PASS = "mW8%wB5!";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBase getInstance() {
        if (db_instance == null)
            db_instance = new DataBase();
        return db_instance;
    }

    public Client printClients() {

        Client result = new Client();

        try (PreparedStatement ps = myConn.prepareStatement("SELECT * FROM CLIENT");
             ResultSet rs = ps.executeQuery()) {

            rs.next();
            result.setId(rs.getInt("client_id"));
            result.setFirstName(rs.getString("first_name"));
            result.setLastName(rs.getString("last_name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createClient(String firstName, String lastName) {

        try (PreparedStatement ps = myConn.prepareStatement("INSERT INTO CLIENT(first_name,last_name) VALUES(?,?);");
             PreparedStatement ps2 = myConn.prepareStatement("SELECT client_id FROM CLIENT WHERE first_name = ? AND last_name = ?");
             ResultSet rs = ps2.executeQuery();
             PreparedStatement ps3 = myConn.prepareStatement("INSERT INTO CARD(card_money,expire_on,client_id) VALUES(0,null,?);");
             PreparedStatement ps4 = myConn.prepareStatement("SELECT card_id FROM CARD WHERE client_id = ?");
             ResultSet rs2 = ps4.executeQuery();
             PreparedStatement ps5 = myConn.prepareStatement("INSERT INTO CARD_TYPE(pass_type,price,card_id) VALUES('recharge',null,?);")) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeUpdate();

            ps2.setString(1, firstName);
            ps2.setString(2, lastName);

            rs.next();
            int client_id = rs.getInt("client_id");

            ps3.setInt(1, client_id);
            ps3.executeUpdate();

            ps4.setInt(1, client_id);
            rs2.next();
            int card_id = rs2.getInt("card_id");
            ps5.setInt(1, card_id);
            ps5.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void chargePass(Card card) {
        Client person = new Client();
        person = card.getPerson();

        try (PreparedStatement ps = myConn.prepareStatement("SELECT cr.card_id FROM CLIENT cl, CARD cr WHERE cl.client_id = cr.client_id AND cl.first_name = ? AND cl.last_name = ?;");

             PreparedStatement ps2 = myConn.prepareStatement("UPDATE CARD_TYPE SET pass_type = ?, price = ? WHERE card_id = ?;");
             PreparedStatement ps3 = myConn.prepareStatement("UPDATE CARD SET card_money = card_money + ? WHERE card_id = ?")) {

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            card.setCard_id(rs.getInt("card_id"));

            if (!card.getPass_type().equals("recharge")) {
                ps2.setString(1, card.getPass_type());
                ps2.setFloat(2, card.getPass_price());
                ps2.setInt(3, card.getCard_id());
                ps2.executeUpdate();
            } else {
                ps2.setString(1,card.getPass_type());
                ps2.setFloat(2,0);
                ps2.setInt(3,card.getCard_id());
                ps2.executeUpdate();

                ps3.setFloat(1, card.getPass_price());
                ps3.setInt(2, card.getCard_id());
                ps3.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

