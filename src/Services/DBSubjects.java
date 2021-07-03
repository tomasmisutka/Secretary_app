package Services;

import Common.Constants;
import Common.Enums.Classification;
import Common.Enums.Language;
import Common.SQLStatements;
import Common.Subject;

import java.sql.*;
import java.util.ArrayList;

public class DBSubjects
{
    public DBSubjects()
    {
    }

    /* This method sends new Subject to DB*/
    public boolean sendSubjectToDB(Subject newSubject, int studyGroupID)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_SUBJECT);
            prepareStatement.setInt(1,newSubject.getId());
            prepareStatement.setString(2, newSubject.getAbbreviation().toLowerCase());
            prepareStatement.setInt(3, newSubject.getWeeksCount());
            prepareStatement.setInt(4, newSubject.getLecturesCount());
            prepareStatement.setInt(5, newSubject.getPracticesCount());
            prepareStatement.setInt(6, newSubject.getSeminarsCount());
            prepareStatement.setString(7, newSubject.getClassification().toString().toLowerCase());
            prepareStatement.setString(8, newSubject.getLanguage().toString().toLowerCase());
            prepareStatement.setInt(9, newSubject.getDefaultGroupSize());
            prepareStatement.setInt(10, studyGroupID);
            prepareStatement.execute();
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public Subject getSubjectById(int id)
    {
        Subject subject = null;
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_SUBJECT_BY_ID);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next())
            {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setAbbreviation(resultSet.getString("abbreviation"));
                subject.setWeeksCount(resultSet.getInt("weeks_count"));
                subject.setLecturesCount(resultSet.getInt("lectures_count"));
                subject.setPracticesCount(resultSet.getInt("practises_count"));
                subject.setSeminarsCount(resultSet.getInt("seminars_count"));
                subject.setClassification(Classification.valueOf(resultSet.getString("classification").toUpperCase()));
                subject.setLanguage(Language.valueOf(resultSet.getString("teach_language").toUpperCase()));
                subject.setDefaultGroupSize(resultSet.getInt("class_size"));
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return null;
        }
        return subject;
    }

    public ArrayList<Subject> getSubjects()
    {
        ArrayList<Subject> subjects = new ArrayList<>();
        Connection connection;

        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_SUBJECTS);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setAbbreviation(resultSet.getString("abbreviation"));
                subject.setWeeksCount(resultSet.getInt("weeks_count"));
                subject.setLecturesCount(resultSet.getInt("lectures_count"));
                subject.setPracticesCount(resultSet.getInt("practises_count"));
                subject.setSeminarsCount(resultSet.getInt("seminars_count"));
                subject.setClassification(Classification.valueOf(resultSet.getString("classification").toUpperCase()));
                subject.setLanguage(Language.valueOf(resultSet.getString("teach_language").toUpperCase()));
                subject.setDefaultGroupSize(resultSet.getInt("class_size"));

                subjects.add(subject);
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return subjects;
        }
        return subjects;
    }

    public boolean removeSubject(Subject subject)
    {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.DELETE_SUBJECT_BY_ID);
            prepareStatement.setInt(1, subject.getId());
            prepareStatement.executeUpdate();
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }
}
