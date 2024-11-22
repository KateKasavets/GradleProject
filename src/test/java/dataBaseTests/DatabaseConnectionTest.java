package dataBaseTests;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {

    @Test
    public void testConnection() {
        Connection connection = DatabaseConnection.connectionToDB();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT version();")) {

            if (resultSet.next()) {
                System.out.println("The connection is successful! Database version: " + resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}
