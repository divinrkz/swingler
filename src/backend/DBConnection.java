package backend;

import java.sql.*;


public class DBConnection {
    public static Connection connectToDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/desktop_app_db?useSSL=false","root","");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
