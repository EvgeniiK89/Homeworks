package HomeWorkApp6.server.db;

import java.security.interfaces.RSAKey;
import java.sql.*;

public class DBUtils {

    private static final String DB_CONNECTION_STRING = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\db\\mdb.db";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DB_CONNECTION_STRING);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static boolean auth(String login, String pass) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "Select * from `users` where login = ? and password = ?"
            );
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
