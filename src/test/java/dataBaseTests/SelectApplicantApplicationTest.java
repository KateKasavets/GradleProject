package dataBaseTests;

import org.testng.annotations.Test;

import java.sql.*;

public class SelectApplicantApplicationTest extends BaseDbTest {

    @Test
    public void testSelectApplicantAndApplication() {
        String selectQuery = "SELECT applicants.surname, applicants.name, applications.kindofapplication, applications.statusofapplication " +
                "FROM reg_office.applicants " +
                "JOIN reg_office.applications ON reg_office.applicants.applicantid = reg_office.applications.applicantid " +
                "ORDER BY applications.statusofapplication " +
                "LIMIT 25";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String kindOfApplication = resultSet.getString("kindofapplication");
                String statusOfApplication = resultSet.getString("statusofapplication");

                System.out.println("Surname: " + surname + ",Name: " + name +
                        ", Kind of Application: " + kindOfApplication +
                        ", Status of Application: " + statusOfApplication);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
