package Services;

import Common.WorkloadWeights;

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

    public WorkloadWeights getWorkLoadWeights()
    {
        WorkloadWeights workloadWeights = null;
        try
        {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    "student", "student");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM WorkloadWeights");

            while (resultSet.next())
            {
                workloadWeights = new WorkloadWeights(resultSet.getDouble("LectureHour"), resultSet.getDouble("PractiseHour"),
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
        return workloadWeights;
    }
}