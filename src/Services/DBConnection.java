package Services;

import Common.Constants;
import Common.Employee;
import Common.GlobalConfig;
import Common.Subject;

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

    public static DBConnection getDbConnection()
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

            ResultSet resultSet = statement.executeQuery("SELECT * FROM GlobalConfig");

            while (resultSet.next())
            {
                globalConfig = new GlobalConfig(resultSet.getDouble("LectureHour"), resultSet.getDouble("PractiseHour"),
                        resultSet.getDouble("SeminarHour"), resultSet.getDouble("LectureHourEN"),
                        resultSet.getDouble("PractiseHourEN"), resultSet.getDouble("SeminarHourEN"),
                        resultSet.getDouble("MidTermExam"), resultSet.getDouble("ClassifiedExam"),
                        resultSet.getDouble("Exam"), resultSet.getDouble("MidTermExamEN"),
                        resultSet.getDouble("ClassifiedExamEN"), resultSet.getDouble("ExamEN"));
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
}