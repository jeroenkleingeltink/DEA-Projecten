package jeroen.school.dea.DataSource.Utilities;

import java.io.IOException;
import java.util.Properties;

public class DBProperties implements IDBProperties {
    private Properties properties;

    /**
     * Constructor
     */
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
    @Override
    public String getDriver() {
        return properties.getProperty("driver");
    }

    /**
     * Returns database connection string
     * @return String
     */
    @Override
    public String getConnectionString() {
        return properties.getProperty("connectionstring");
    }

    /**
     * Returns database username
     * @return String
     */
    @Override
    public String getUsername() {
        return properties.getProperty("username");
    }

    /**
     * Returns database password
     * @return String
     */
    @Override
    public String getPassword() {
        return properties.getProperty("password");
    }
}
