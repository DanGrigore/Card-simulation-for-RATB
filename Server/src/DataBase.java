import java.sql.*;

public class DataBase {
    private Connection myConn;
    private PreparedStatement ps;
    private ResultSet rs;

    public String connect(String sqlCommand) {
        final String DB_URL = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2237743";
        final String DB_USER = "sql2237743";
        final String DB_PASS = "mW8%wB5!";
        String result = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection myConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = myConn.prepareStatement(sqlCommand);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
               result += rs.getString("first_name") + " " + rs.getString("last_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

