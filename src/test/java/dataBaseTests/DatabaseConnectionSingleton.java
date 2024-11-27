package dataBaseTests;

import utils.ConfProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingleton {
    private static Connection connection;

    private DatabaseConnectionSingleton() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = ConfProperties.getDbUrl();
                String user = ConfProperties.getDbUser();
                String password = ConfProperties.getDbPassword();

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection to the database is successful.");
            } catch (SQLException e) {
                System.out.println("Failed  connection.");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close database connection.");
            }
        }
    }
}
