package Services;

import Common.*;
import Common.Enums.EventType;
import Common.Enums.Language;

import java.sql.*;
import java.util.ArrayList;

public class DBWorkLabels
{
    public DBWorkLabels() {}

    /* This method sends new WorkLabel to DB */
    public boolean sendWorkLabelToDB(WorkLabel newWorkLabel)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_WORK_LABEL);
            prepareStatement.setInt(1, DBConnection.getInstance().getAvailableIndex(SQLStatements.TABLE_NAME_WORK_LABELS));
            prepareStatement.setString(1, newWorkLabel.getName());
            prepareStatement.setNull(2, Types.INTEGER);
            prepareStatement.setNull(3, Types.INTEGER);
            prepareStatement.setString(4, newWorkLabel.getEventType().toString().toLowerCase());
            prepareStatement.setInt(5, newWorkLabel.getStudentsCount());
            prepareStatement.setInt(6, newWorkLabel.getHoursCount());
            prepareStatement.setInt(7, newWorkLabel.getWeeksCount());
            prepareStatement.setString(8, newWorkLabel.getLanguage().toString().toLowerCase());
            prepareStatement.setInt(9, newWorkLabel.getTotalPoints());

            prepareStatement.execute();
            connection.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<WorkLabel> getUnassignedWorkLabels()
    {
        ArrayList<WorkLabel> workLabels = new ArrayList<>();
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_UNASSIGNED_WORK_LABELS);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                WorkLabel workLabel = new WorkLabel();

                workLabel.setId(resultSet.getInt("id"));
                workLabel.setName(resultSet.getString("name"));
                workLabel.setEmployee(new Employee());
                workLabel.setSubject(new Subject());
                workLabel.setEventType(EventType.valueOf(resultSet.getString("event_type").toUpperCase()));
                workLabel.setStudentsCount(resultSet.getInt("students_count"));
                workLabel.setHoursCount(resultSet.getInt("hours_count"));
                workLabel.setWeeksCount(resultSet.getInt("weeks_count"));
                workLabel.setLanguage(Language.valueOf(resultSet.getString("language_used").toUpperCase()));
                workLabel.setTotalPoints(resultSet.getInt("total_points"));

                workLabels.add(workLabel);
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return workLabels;
        }
        return workLabels;
    }

    public ArrayList<WorkLabel> getWorkLabelsAssignedToEmployee(int employeeId, DBEmployees dbEmployees,
                                                                DBSubjects dbSubjects)
    {
        ArrayList<WorkLabel> workLabels = new ArrayList<>();
        Connection connection;

        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_WORK_LABELS_ASSIGNED_TO_EMPLOYEE);
            prepareStatement.setInt(1, employeeId);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                WorkLabel workLabel = new WorkLabel();
                workLabel.setId(resultSet.getInt("id"));
                workLabel.setName(resultSet.getString("name"));
                workLabel.setEmployee(dbEmployees.getEmployeeById(resultSet.getInt("employee_id")));
                workLabel.setSubject(dbSubjects.getSubjectById(resultSet.getInt("subject_id")));
                workLabel.setEventType(EventType.valueOf(resultSet.getString("event_type").toUpperCase()));
                workLabel.setStudentsCount(resultSet.getInt("students_count"));
                workLabel.setHoursCount(resultSet.getInt("hours_count"));
                workLabel.setWeeksCount(resultSet.getInt("weeks_count"));
                workLabel.setLanguage(Language.valueOf(resultSet.getString("language_used").toUpperCase()));
                workLabel.setTotalPoints(resultSet.getInt("total_points"));

                workLabels.add(workLabel);
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return workLabels;
        }
        return workLabels;
    }
}
