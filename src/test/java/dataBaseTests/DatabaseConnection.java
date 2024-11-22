package dataBaseTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConfProperties;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    private static final Logger log = LogManager.getLogger(DatabaseConnection.class);
    private static Connection con = null;

    public static Connection connectionToDB() {
        try {
            String url = ConfProperties.getDbUrl();
            String user = ConfProperties.getDbUser();
            String password = ConfProperties.getDbPassword();

            con = DriverManager.getConnection(url, user, password);
            log.info("Connection is successful");
        } catch (Exception e) {
            log.error("Failed to connect to DB", e);
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
                log.info("Connection closed.");
            }
        } catch (Exception e) {
            log.error("Failed to close connection", e);
        }
    }
}