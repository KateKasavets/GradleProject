package dataBaseTests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApplicantApplicationTest {

    @Test
    public void testSelectApplicantAndApplication() {
        String selectQuery = "SELECT applicants.surname, applicants.name, applications.kindofapplication, applications.statusofapplication " +
                "FROM reg_office.applicants " +
                "JOIN reg_office.applications ON reg_office.applicants.applicantid = reg_office.applications.applicantid " +
                "ORDER BY applications.statusofapplication " +
                "LIMIT 25";

        try (Connection connection = DatabaseConnection.connectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String kindOfApplication = resultSet.getString("kindofapplication");
                String statusOfApplication = resultSet.getString("statusofapplication");

                System.out.println("Surname: "+ surname + ",Name: " + name +
                        ", Kind of Application: " + kindOfApplication +
                        ", Status of Application: " + statusOfApplication);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при выполнении запроса: "+ e.getMessage());
        }
    }
}
