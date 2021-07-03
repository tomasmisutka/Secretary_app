package Services;

import Common.Constants;
import Common.Employee;
import Common.Message;
import Common.SQLStatements;
import Components.MessageDialog;

import java.sql.*;
import java.util.ArrayList;

public class DBEmployees
{

    public DBEmployees() {}

    /* This method check, if this full name already exists in DB
        return 0 - any error occurs
        return 1 - this employee name already exists
        return 2 - this name is available
    * */
    private int checkFullNameExistential(Connection connection, String employeesFullName)
    {
        try
        {
            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.COMPARE_EMPLOYEE_NAME);
            prepareStatement.setString(1, employeesFullName);
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
                int userExistential = this.checkFullNameExistential(connection, employee.getFullName());

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
            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.NEW_EMPLOYEE);
            prepareStatement.setInt(1, employee.getId());
            prepareStatement.setString(2, employee.getFirstName());
            prepareStatement.setString(3, employee.getLastName());
            prepareStatement.setString(4, employee.getFullName());
            prepareStatement.setString(5, employee.getPrivateEmail().toLowerCase());
            prepareStatement.setString(6, employee.getJobEmail().toLowerCase());
            prepareStatement.setInt(7, employee.getWorkPoints());
            prepareStatement.setInt(8, employee.getWorkPointsEN());
            prepareStatement.setBoolean(9, employee.isDoctoral());
            prepareStatement.setDouble(10, employee.getWorkLoad());
            prepareStatement.execute();

            connection.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    /* This method return all employees from DB */
    public ArrayList<Employee> getEmployees()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.GET_EMPLOYEES);
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

    /* This method update an employee according to id */
    public boolean updateEmployee(Employee employee)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.UPDATE_EMPLOYEE_BY_ID);
            prepareStatement.setString(1, employee.getFirstName());
            prepareStatement.setString(2, employee.getLastName());
            prepareStatement.setString(3, employee.getFullName());
            prepareStatement.setString(4, employee.getPrivateEmail());
            prepareStatement.setString(5, employee.getJobEmail());
            prepareStatement.setInt(6, employee.getWorkPoints());
            prepareStatement.setInt(7, employee.getWorkPointsEN());
            prepareStatement.setBoolean(8, employee.isDoctoral());
            prepareStatement.setDouble(9, employee.getWorkLoad());
            prepareStatement.setInt(10, employee.getId());
            prepareStatement.execute();

            connection.close();

        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public Employee getEmployeeById(int id)
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

    public boolean deleteEmployeeById(int employeeId)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.REMOVE_EMPLOYEE_BY_ID);
            prepareStatement.setInt(1, employeeId);

            prepareStatement.executeUpdate();
            connection.close();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateEmployeeIdInWorkLabel(int employeeId, int workLabelID)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(SQLStatements.CONNECTION,
                    Constants.dbLoginName, Constants.dbLoginPassword);

            PreparedStatement prepareStatement = connection.prepareStatement(SQLStatements.UPDATE_EMPLOYEE_ID_IN_WORK_LABEL);
            prepareStatement.setInt(1, employeeId);
            prepareStatement.setInt(2, workLabelID);
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
