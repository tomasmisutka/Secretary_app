package Services;

import Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBConnection {
    private static DBConnection dbConnection = null;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }

    /* This method return the last configured global config */
    public GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = null;
        try {
            Connection connection = DriverManager.getConnection(SqlStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SqlStatements.GLOBAL_CONFIGS_DB);

            while (resultSet.next()) {
                globalConfig = new GlobalConfig(resultSet.getDouble("hour_lecture"), resultSet.getDouble("hour_practise"),
                        resultSet.getDouble("hour_seminar"), resultSet.getDouble("hour_lecture_en"),
                        resultSet.getDouble("hour_practise_en"), resultSet.getDouble("hour_seminar_en"),
                        resultSet.getDouble("mid_term_exam"), resultSet.getDouble("classified_exam"),
                        resultSet.getDouble("exam"), resultSet.getDouble("mid_term_exam_en"),
                        resultSet.getDouble("classified_exam_en"), resultSet.getDouble("exam_en"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return globalConfig;
    }

    /* This method sends new employee to DB */
    public boolean sendEmployeeToDB(Employee employee) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(SqlStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);
            PreparedStatement prepareStatement = connection.prepareStatement(SqlStatements.NEW_EMPLOYEE_STATEMENT);
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

        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    /* This method sends new Subject to DB*/
    public boolean sendSubjectToDB(Subject newSubject) {
        Connection connection = null;
        try {
            ;
            connection = DriverManager.getConnection(SqlStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SqlStatements.NEW_SUBJECT_STATEMENT);
            prepareStatement.setString(1, newSubject.getAbbreviation());
            prepareStatement.setInt(2, newSubject.getWeeksCount());
            prepareStatement.setInt(3, newSubject.getLecturesCount());
            prepareStatement.setInt(4, newSubject.getPracticesCount());
            prepareStatement.setInt(5, newSubject.getSeminarsCount());
            prepareStatement.setString(6, newSubject.getClassification().toString());
            prepareStatement.setString(7, newSubject.getLanguage().toString());
            prepareStatement.setInt(8, newSubject.getDefaultGroupSize());
            prepareStatement.setNull(9, Types.INTEGER);

            prepareStatement.execute();
            connection.close();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    /* This method sends new Study Group to DB */
    public boolean sendStudyGroupToDB(StudyGroup newStudyGroup) {
        return true;
    }

    /* This method sends new WorkLabel to DB */
    public boolean sendWorkLabelToDB(WorkLabel newWorkLabel) {
        return true;
    }
}