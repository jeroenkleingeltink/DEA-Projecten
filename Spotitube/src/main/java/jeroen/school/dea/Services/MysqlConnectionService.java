package jeroen.school.dea.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionService {
    private static String url = "jdbc:mysql://ts.marco.codes:3306/jeroenSpotitube";
    private static String drivername = "com.mysql.jdbc.Driver";
    private static String username = "jeroen";
    private static String password = ".sWWZ%.tRBCBnzNw&Hh>tti)";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(drivername);

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Failed to create database connection!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
        }

        return connection;
    }
}
