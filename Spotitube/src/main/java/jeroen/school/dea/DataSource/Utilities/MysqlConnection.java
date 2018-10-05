package jeroen.school.dea.DataSource.Utilities;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MysqlConnection {
    private static Connection connection;

    @Inject
    private static DBProperties pr;

    private MysqlConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {

                Class.forName(pr.getDriver());

                try {

                    connection = DriverManager.getConnection(pr.getConnectionString(), pr.getUsername(), pr.getPassword());

                } catch (SQLException e) {

                    System.out.println("Failed to create database connection!");

                }

            } catch (ClassNotFoundException e) {

                System.out.println("Driver not found!");

            }
        }

        return connection;
    }
}
