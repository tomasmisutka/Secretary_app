package Components.Panels;

import Common.Employee;
import Components.EmployeeCard;
import Components.WrapLayout;
import Services.DBConnection;

import javax.swing.*;
import java.util.ArrayList;

public class EmployeesPanel extends JPanel
{
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static EmployeesPanel employeesPanel = null;

    private EmployeesPanel()
    {
        this.setLayout(new WrapLayout(WrapLayout.LEFT, 30, 20));
        this.prepareContent();
    }

    public static EmployeesPanel getInstance()
    {
        if (employeesPanel == null)
            employeesPanel = new EmployeesPanel();
        return employeesPanel;
    }

    private void prepareContent()
    {
        employees = DBConnection.getInstance().getAllEmployees();

        for (Employee employee : employees)
            this.add(new EmployeeCard(employee));
    }

    public boolean addNewEmployee(Employee employee)
    {
        boolean success = DBConnection.getInstance().sendEmployeeToDB(employee);
        if (success)
        {
            employees.add(employee);
            this.add(new EmployeeCard(employee));
            this.revalidate();
        }
        return success;
    }

    public void removeEmployee(EmployeeCard employeeCard)
    {
        boolean success = DBConnection.getInstance().deleteEmployeeById(employeeCard.getEmployee().getId());
        if (success)
        {
            employees.remove(employeeCard.getEmployee());
            this.remove(employeeCard);
            this.revalidate();
            this.repaint();
        }
    }

}
