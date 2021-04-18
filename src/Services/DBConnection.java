package Services;

import Common.Constants;
import Common.Employee;
import Common.GlobalConfig;
import Common.StudyGroup;
import Common.Subject;
import Common.WorkLabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBConnection
{
    private static DBConnection dbConnection = null;

    private DBConnection()
    {
    }

    public static DBConnection getInstance()
    {
        if (dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }

    public GlobalConfig getGlobalConfig()
    {
        GlobalConfig globalConfig = null;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    Constants.dbLoginName, Constants.dbLoginPassword);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM global_configs");

            while (resultSet.next())
            {
                globalConfig = new GlobalConfig(resultSet.getDouble("hour_lecture"), resultSet.getDouble("hour_practise"),
                        resultSet.getDouble("hour_seminar"), resultSet.getDouble("hour_lecture_en"),
                        resultSet.getDouble("hour_practise_en"), resultSet.getDouble("hour_seminar_en"),
                        resultSet.getDouble("mid_term_exam"), resultSet.getDouble("classified_exam"),
                        resultSet.getDouble("exam"), resultSet.getDouble("mid_term_exam_en"),
                        resultSet.getDouble("classified_exam_en"), resultSet.getDouble("exam_en"));
            }
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
        return globalConfig;
    }

    public boolean sendEmployeeToDB(Employee employee)
    {
        Connection connection = null;
        try
        {
            String insertQuery = "INSERT INTO Employees (FirstName, LastName, FullName, PrivateEmail, JobEmail, WorkPoints, " +
                    "WorkPointsEN, IsDoctoral, WorkLoad, WorkLabelID)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    Constants.dbLoginName, Constants.dbLoginPassword);
            PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);
            prepareStatement.setString(1, employee.getFirstName());
            prepareStatement.setString(2, employee.getLastName());
            prepareStatement.setString(3, employee.getFullName());
            prepareStatement.setString(4, employee.getPrivateEmail());
            prepareStatement.setString(5, employee.getJobEmail());
            prepareStatement.setInt(6, employee.getWorkPoints());
            prepareStatement.setInt(7, employee.getWorkPointsEN());
            prepareStatement.setBoolean(8, employee.isDoctoral());
            prepareStatement.setDouble(9, employee.getWorkLoad());
            prepareStatement.setNull(10, Types.INTEGER);

            prepareStatement.execute();
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean sendSubjectToDB(Subject newSubject)
    {
        Connection connection = null;
        try
        {
            String insertQuery = "INSERT INTO Subjects (Abbreviation, WeeksCount, LecturesCount, PractisesCount, SeminarsCount, Classification, " +
                    "TeachLanguage, ClassSize, StudyGroupID)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);
            prepareStatement.setString(1,newSubject.getAbbreviation());
            prepareStatement.setInt(2,newSubject.getWeeksCount());
            prepareStatement.setInt(3,newSubject.getLecturesCount());
            prepareStatement.setInt(4,newSubject.getPracticesCount());
            prepareStatement.setInt(5,newSubject.getSeminarsCount());
            prepareStatement.setString(6,newSubject.getClassification().toString());
            prepareStatement.setString(7,newSubject.getLanguage().toString());
            prepareStatement.setInt(8,newSubject.getDefaultGroupSize());
            prepareStatement.setNull(9, Types.INTEGER);

            prepareStatement.execute();
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean sendStudyGroupToDB(StudyGroup newStudyGroup)
    {
        return true;
    }

    public boolean sendWorkLabelToDB(WorkLabel newWorkLabel)
    {
        return true;
    }
}