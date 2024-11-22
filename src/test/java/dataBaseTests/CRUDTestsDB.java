package dataBaseTests;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTestsDB {
    private final String surname = "Kasavets";
    private final String name = "Katee";
    private final String updatedName = "Ivanov";
    private final String middlename = "middlename";
    private final String passportNumber = "KU784512";
    private final String phoneNumber = "78451212";
    private final String updatedPhoneNumber = "9001234567";
    private int applicantId;

    @Test
    public void testInsertApplicant() {
        String insertQuery = "INSERT INTO reg_office.applicants (surname, name, middlename,passportnumber,phonenumber) " +
                "VALUES ('" + surname + "', '" + name + "', '" + middlename + "', '" + passportNumber + "', '" + phoneNumber + "')";

        try (Connection connection = DatabaseConnection.connectionToDB()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
                System.out.println("Пользователь добавлен успешно.");

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        applicantId = generatedKeys.getInt(1);
                        System.out.println("ID новой записи: " + applicantId);
                    } else {
                        throw new SQLException("ID новой записи не найден.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при вставке данных: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testInsertApplicant")
    public void testReadApplicant() {
        String selectQuery = "SELECT * FROM reg_office.applicants WHERE surname = '" +surname + "'";

        try (Connection connection = DatabaseConnection.connectionToDB()) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                if (resultSet.next()) {
                    System.out.println("Фамилия:" + resultSet.getString("surname"));
                    System.out.println("Имя:" + resultSet.getString("name"));
                } else {
                    System.out.println("Пользователь не найден.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при получении данных: "+ e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testReadApplicant")
    public void testUpdateApplicant() {
        String updateQuery = "UPDATE reg_office.applicants SET name = '" + updatedName + "',phonenumber = '" + updatedPhoneNumber + "' " +
                "WHERE applicantid = "+ applicantId;

        try (Connection connection = DatabaseConnection.connectionToDB()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(updateQuery);
                System.out.println("Пользователь обновлен успешно.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при обновлении данных: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testUpdateApplicant")
    public void testDeleteApplicant() {
        String deleteQuery = "DELETE FROM reg_office.applicants WHERE passportnumber = '"+ passportNumber + "'";

        try (Connection connection = DatabaseConnection.connectionToDB()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(deleteQuery);
                System.out.println("Пользователь удален успешно.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при удалении данных:" + e.getMessage());
        }
    }
}
