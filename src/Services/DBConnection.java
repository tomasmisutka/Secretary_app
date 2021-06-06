package Services;

import Common.*;
import Common.Enums.Classification;
import Common.Enums.EventType;
import Common.Enums.Language;
import Components.MessageDialog;
import Components.Panels.DashboardBodyPanel;

import java.sql.*;
import java.util.ArrayList;

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

    /* This method return the last configured global config */
    public GlobalConfig getGlobalConfig()
    {
        GlobalConfig globalConfig = null;
        try
        {
            Connection connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLStatements.SELECT_GLOBAL_CONFIGS_STATEMENT);

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

    /* This method sends new employee to DB */
    public boolean sendEmployeeToDB(Employee employee)
    {
        Connection connection = null;
        try
        {

            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            int sameFullNameCounter = 0;
            String originalFullName = employee.getFullName();
            String originalLastName = employee.getLastName();
            while (true)
            {
                sameFullNameCounter++;
                int userExistential = this.checkFullNameExistential(connection, employee);

                if (userExistential == Constants.ERROR_OCCURS)
                {
                    MessageDialog.showErrorDialog(null, Message.DB_EMPLOYEE_NAME_CHECK_ERROR);
                    return false;
                }
                if (userExistential == Constants.NAME_AVAILABLE)
                    break;

                if (userExistential == Constants.EMPLOYEE_EXISTS)
                {
                    employee.setFullName(originalFullName + sameFullNameCounter);
                    employee.setLastName(originalLastName + sameFullNameCounter);
                }

            }

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_EMPLOYEE_STATEMENT);
            prepareStatement.setString(1, employee.getFirstName());
            prepareStatement.setString(2, employee.getLastName());
            prepareStatement.setString(3, employee.getFullName());
            prepareStatement.setString(4, employee.getPrivateEmail().toLowerCase());
            prepareStatement.setString(5, employee.getJobEmail().toLowerCase());
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
        DashboardBodyPanel.repaintEmployeesPanel();
        return true;
    }

    /* This method check, if this full name already exists in DB
        return 0 - any error occurs
        return 1 - this employee name already exists
        return 2 - this name is available
    * */
    private int checkFullNameExistential(Connection connection, Employee employee)
    {
        try
        {
            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.COMPARE_EMPLOYEE_NAME_STATEMENT);
            prepareStatement.setString(1, employee.getFullName());
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next())
                return Constants.EMPLOYEE_EXISTS;

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return Constants.ERROR_OCCURS;
        }
        return Constants.NAME_AVAILABLE;
    }

    public ArrayList<Employee> getAllEmployees()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_ALL_EMPLOYEES_STATEMENT);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setFullName(resultSet.getString("full_name"));
                employee.setPrivateEmail(resultSet.getString("private_email"));
                employee.setJobEmail(resultSet.getString("job_email"));
                employee.setWorkPoints(resultSet.getInt("work_points"));
                employee.setWorkPointsEN(resultSet.getInt("work_points_en"));
                employee.setDoctoral(resultSet.getBoolean("is_doctoral"));
                employee.setWorkLoad(resultSet.getDouble("work_load"));

                employees.add(employee);
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return employees;
        }
        return employees;
    }


    /* This method sends new Subject to DB*/
    public boolean sendSubjectToDB(Subject newSubject)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_SUBJECT_STATEMENT);
            prepareStatement.setString(1, newSubject.getAbbreviation().toLowerCase());
            prepareStatement.setInt(2, newSubject.getWeeksCount());
            prepareStatement.setInt(3, newSubject.getLecturesCount());
            prepareStatement.setInt(4, newSubject.getPracticesCount());
            prepareStatement.setInt(5, newSubject.getSeminarsCount());
            prepareStatement.setString(6, newSubject.getClassification().toString().toLowerCase());
            prepareStatement.setString(7, newSubject.getLanguage().toString().toLowerCase());
            prepareStatement.setInt(8, newSubject.getDefaultGroupSize());
            prepareStatement.setNull(9, Types.INTEGER);

            //todo here will be private method to calculate and create new work labels
            prepareStatement.execute();
            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    /* This method sends new Study Group to DB */
    public boolean sendStudyGroupToDB(StudyGroup newStudyGroup)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_STUDY_GROUP_STATEMENT);
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

    /* This method sends new WorkLabel to DB */
    private boolean sendWorkLabelToDB(WorkLabel newWorkLabel)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_WORK_LABEL_STATEMENT);
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

    public ArrayList<WorkLabel> getAllWorkLabels()
    {
        ArrayList<WorkLabel> workLabels = new ArrayList<>();
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_ALL_WORK_LABELS_STATEMENT);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                WorkLabel workLabel = new WorkLabel();

                workLabel.setId(resultSet.getInt("id"));
                workLabel.setName(resultSet.getString("name"));
                workLabel.setEmployee(this.getEmployeeById(0));
                workLabel.setSubject(this.getSubjectById(0));
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

    private Employee getEmployeeById(int id)
    {
        Employee employee = null;
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_EMPLOYEE_BY_ID);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next())
            {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setFullName(resultSet.getString("full_name"));
                employee.setPrivateEmail(resultSet.getString("private_email"));
                employee.setJobEmail(resultSet.getString("job_email"));
                employee.setWorkPoints(resultSet.getInt("work_points"));
                employee.setWorkPointsEN(resultSet.getInt("work_points_en"));
                employee.setDoctoral(resultSet.getBoolean("is_doctoral"));
                employee.setWorkLoad(resultSet.getDouble("work_load"));
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return null;
        }
        return employee;
    }

    private Subject getSubjectById(int id)
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
                //todo - here will be maybe implementation to add new studygroup to array list
//                subject.get(resultSet.getDouble("study_group_id"));
            }
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return null;
        }
        return subject;
    }

}