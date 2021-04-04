package Services;

import Common.GlobalConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection
{
    public DBConnection()
    {
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
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return globalConfig;
    }
}