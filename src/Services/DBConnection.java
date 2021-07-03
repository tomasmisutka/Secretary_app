package Services;

import Common.*;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection
{
    private static DBConnection dbConnection = null;
    private final DBEmployees dbEmployees;
    private final DBSubjects dbSubjects;
    private final DBWorkLabels dbWorkLabels;
    private final DBStudyGroup dbStudyGroup;

    private DBConnection()
    {
        this.dbEmployees = new DBEmployees();
        this.dbSubjects = new DBSubjects();
        this.dbWorkLabels = new DBWorkLabels();
        this.dbStudyGroup = new DBStudyGroup();
    }

    public static DBConnection getInstance()
    {
        if (dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }

    /* This method return the last configured global config */
    public GlobalConfig getGlobalConfig()
    {
        GlobalConfig globalConfig = null;
        try
        {
            Connection connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLStatements.SELECT_GLOBAL_CONFIGS);

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
        return dbEmployees.sendEmployeeToDB(employee);
    }

    public ArrayList<Employee> getEmployees()
    {
        return dbEmployees.getEmployees();
    }

    public boolean updateEmployee(Employee employee)
    {
        return dbEmployees.updateEmployee(employee);
    }

    public boolean sendSubjectToDB(Subject newSubject, int studyGroupID)
    {
        return dbSubjects.sendSubjectToDB(newSubject, studyGroupID);
    }

    public boolean sendStudyGroupToDB(StudyGroup newStudyGroup)
    {
        return dbStudyGroup.sendStudyGroupToDB(newStudyGroup);
    }

    private boolean sendWorkLabelToDB(WorkLabel newWorkLabel)
    {
        return dbWorkLabels.sendWorkLabelToDB(newWorkLabel);
    }

    public int getAvailableIndex(String tableNameWorkLabels)
    {
        int availableIndex = 0;
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);
            String AVAILABLE_ID_QUERY = SQLStatements.GET_AVAILABLE_ID.replace("$table_name", tableNameWorkLabels);
            PreparedStatement prepareStatement = connection.prepareStatement(AVAILABLE_ID_QUERY);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next())
                availableIndex = resultSet.getInt(1);
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return availableIndex;
        }
        return availableIndex;
    }

    public ArrayList<WorkLabel> getUnassignedWorkLabels()
    {
        return dbWorkLabels.getUnassignedWorkLabels();
    }

    public Employee getEmployeeById(int id)
    {
        return dbEmployees.getEmployeeById(id);
    }

    private Subject getSubjectById(int id)
    {
        return dbSubjects.getSubjectById(id);
    }

    public boolean deleteEmployeeById(int employeeId)
    {
        return dbEmployees.deleteEmployeeById(employeeId);
    }

    public boolean updateEmployeeIdInWorkLabel(int employeeId, int workLabelID)
    {
        return dbEmployees.updateEmployeeIdInWorkLabel(employeeId, workLabelID);
    }

    public ArrayList<WorkLabel> getWorkLabelsAssignedToEmployee(int employeeId)
    {
        return dbWorkLabels.getWorkLabelsAssignedToEmployee(employeeId, dbEmployees, dbSubjects);
    }

    public ArrayList<Subject> getSubjects()
    {
        return dbSubjects.getSubjects();
    }

    public ArrayList<StudyGroup> getStudyGroups()
    {
        return dbStudyGroup.getStudyGroups();
    }

    public boolean removeSubject(Subject subject)
    {
        return dbSubjects.removeSubject(subject);
    }

    public boolean addStudyGroupToSubject(Subject subject, StudyGroup studyGroup)
    {
        return dbSubjects.sendSubjectToDB(subject, studyGroup.getId());
    }

    public ArrayList<StudyGroup> getStudyGroupsForSubject(Subject subject)
    {
        return dbStudyGroup.getStudyGroupsForSubject(subject);
    }
}