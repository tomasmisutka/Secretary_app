package Services;

import Common.Employee;
import Common.GlobalConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBConnection
{
    private static final DBConnection dbConnection = new DBConnection();

    private DBConnection()
    {
    }

    public static DBConnection getDbConnection()
    {
        if (dbConnection == null)
            return new DBConnection();
        return dbConnection;
    }

    public GlobalConfig getGlobalConfig()
    {
        GlobalConfig globalConfig = null;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    "student", "student");
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
                    "student", "student");
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
}