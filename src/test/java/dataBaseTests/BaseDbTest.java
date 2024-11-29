
package dataBaseTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDbTest {
    protected Connection connection;
    protected Statement statement;

    @BeforeClass
    public void setup() {
        connection = DatabaseConnectionSingleton.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to create statement.");
        }
    }

    @AfterClass
    public void teardown() {
        try {
            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Statement closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close statement: " + e.getMessage());
        }
        DatabaseConnectionSingleton.closeConnection();
    }
}
