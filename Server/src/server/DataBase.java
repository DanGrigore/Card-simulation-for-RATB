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

        try {
            PreparedStatement ps = myConn.prepareStatement("INSERT INTO CLIENT(first_name,last_name) VALUES(?,?);");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeUpdate();

            PreparedStatement ps2 = myConn.prepareStatement("SELECT client_id FROM CLIENT WHERE first_name = ? AND last_name = ?");
            ps2.setString(1, firstName);
            ps2.setString(2, lastName);
            ResultSet rs = ps2.executeQuery();
            rs.next();
            int client_id = rs.getInt("client_id");

            PreparedStatement ps3 = myConn.prepareStatement("INSERT INTO CARD(card_money,expire_on,client_id) VALUES(0,null,?);");
            ps3.setInt(1, client_id);
            ps3.executeUpdate();

            ps.close();
            ps2.close();
            ps3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void chargePass(Card card){

        try {

            PreparedStatement ps3 = myConn.prepareStatement("SELECT client_id");
            ps3.executeUpdate();

            ps3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

