package Components.Panels;

import Common.Employee;

import javax.swing.*;

public class EmployeeWorkLabelsPanel extends JPanel
{
    private final Employee employee;

    public EmployeeWorkLabelsPanel(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return employee;
    }
}
