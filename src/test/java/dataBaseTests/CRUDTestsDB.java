package dataBaseTests;

import org.testng.annotations.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTestsDB extends BaseDbTest {
    private final String surname = "Kasavets";
    private final String name = "Katee";
    private final String updatedName = "Ivanov";
    private final String middlename = "middlename";
    private final String passportNumber = "KU784512";
    private final String phoneNumber = "78451212";
    private int applicantId;

    @Test
    public void testInsertApplicant() {
        String insertQuery = "INSERT INTO reg_office.applicants (surname, name, middlename, passportnumber, phonenumber) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, middlename);
            preparedStatement.setString(4, passportNumber);
            preparedStatement.setString(5, phoneNumber);

            preparedStatement.executeUpdate();
            System.out.println("Пользователь добавлен успешно.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    applicantId = generatedKeys.getInt(1);
                    System.out.println("ID новой записи: " + applicantId);
                } else {
                    System.out.println("ID новой записи не найдено.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении записи: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test(dependsOnMethods = "testInsertApplicant")
    public void testReadApplicant() {
        String selectQuery = "SELECT * FROM reg_office.applicants WHERE applicantid = " + applicantId;
        try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
            if (resultSet.next()) {
                System.out.println("Фамилия: " + resultSet.getString("surname"));
                System.out.println("Имя: " + resultSet.getString("name"));
            } else {
                System.out.println("Пользователь не найден.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "testReadApplicant")
    public void testUpdateApplicant() {
        String updateQuery = "UPDATE reg_office.applicants SET name ='" + updatedName + "' " +
                "WHERE applicantid = " + applicantId;
        try {
            statement.executeUpdate(updateQuery);
            System.out.println("Пользователь обновлен успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "testUpdateApplicant")
    public void testDeleteApplicant() {
        String deleteQuery = "DELETE FROM reg_office.applicants WHERE applicantid = " + applicantId;
        try {
            statement.executeUpdate(deleteQuery);
            System.out.println("Пользователь удалён успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
