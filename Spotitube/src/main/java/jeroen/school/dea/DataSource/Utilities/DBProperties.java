package jeroen.school.dea.DataSource.Utilities;

import java.io.IOException;
import java.util.Properties;

public class DBProperties {
    private Properties properties;

    public DBProperties() {
        properties = new Properties();

        try {

            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));

        } catch (IOException e) {

            System.out.println("databaseproperties is stuk.");
            e.printStackTrace();

        }
    }

    /**
     * Returns database driver
     * @return String
     */
    public String getDriver() {
        return properties.getProperty("driver");
    }

    /**
     * Returns database connection string
     * @return String
     */
    public String getConnectionString() {
        return properties.getProperty("connectionstring");
    }

    /**
     * Returns database username
     * @return String
     */
    public String getUsername() {
        return properties.getProperty("username");
    }

    /**
     * Returns database password
     * @return String
     */
    public String getPassword() {
        return properties.getProperty("password");
    }
}
