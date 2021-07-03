package Services;

import Common.Constants;
import Common.Enums.Language;
import Common.Enums.StudyForm;
import Common.Enums.StudyType;
import Common.Enums.Term;
import Common.SQLStatements;
import Common.StudyGroup;
import Common.Subject;

import java.sql.*;
import java.util.ArrayList;

public class DBStudyGroup
{
    public DBStudyGroup()
    {
    }

    /* This method sends new Study Group to DB */
    public boolean sendStudyGroupToDB(StudyGroup newStudyGroup)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_STUDY_GROUP);
            prepareStatement.setString(1, newStudyGroup.getAbbreviation().toLowerCase());
            prepareStatement.setInt(2, newStudyGroup.getYear());
            prepareStatement.setString(3, newStudyGroup.getTerm().toString().toLowerCase());
            prepareStatement.setInt(4, newStudyGroup.getStudentsCount());
            prepareStatement.setString(5, newStudyGroup.getStudyForm().toString().toLowerCase());
            prepareStatement.setString(6, newStudyGroup.getStudyType().toString().toLowerCase());
            prepareStatement.setString(7, newStudyGroup.getLanguage().toString().toLowerCase());

            prepareStatement.execute();
            connection.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<StudyGroup> getStudyGroups()
    {
        ArrayList<StudyGroup> studyGroups = new ArrayList<>();
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_STUDY_GROUPS);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                StudyGroup studyGroup = new StudyGroup();

                studyGroup.setId(resultSet.getInt("id"));
                studyGroup.setAbbreviation(resultSet.getString("abbreviation").toUpperCase());
                studyGroup.setYear(resultSet.getInt("study_year"));
                studyGroup.setTerm(Term.valueOf(resultSet.getString("term").toUpperCase()));
                studyGroup.setStudentsCount(resultSet.getInt("students_count"));
                studyGroup.setStudyForm(StudyForm.valueOf(resultSet.getString("study_form").toUpperCase()));
                studyGroup.setStudyType(StudyType.valueOf(resultSet.getString("study_type").toUpperCase()));
                studyGroup.setLanguage(Language.valueOf(resultSet.getString("study_language").toUpperCase()));

                studyGroups.add(studyGroup);
            }
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return studyGroups;
        }
        return studyGroups;
    }

    public ArrayList<StudyGroup> getStudyGroupsForSubject(Subject subject)
    {
        ArrayList<StudyGroup> studyGroups = new ArrayList<>();

        Connection connection;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_STUDY_GROUPS_FOR_SUBJECT);
            prepareStatement.setInt(1, subject.getId());
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                StudyGroup studyGroup = new StudyGroup();

                studyGroup.setId(resultSet.getInt("id"));
                studyGroup.setAbbreviation(resultSet.getString("abbreviation").toUpperCase());
                studyGroup.setYear(resultSet.getInt("study_year"));
                studyGroup.setTerm(Term.valueOf(resultSet.getString("term").toUpperCase()));
                studyGroup.setStudentsCount(resultSet.getInt("students_count"));
                studyGroup.setStudyForm(StudyForm.valueOf(resultSet.getString("study_form").toUpperCase()));
                studyGroup.setStudyType(StudyType.valueOf(resultSet.getString("study_type").toUpperCase()));
                studyGroup.setLanguage(Language.valueOf(resultSet.getString("study_language").toUpperCase()));

                studyGroups.add(studyGroup);
            }
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return studyGroups;
        }
        return studyGroups;
    }
}
