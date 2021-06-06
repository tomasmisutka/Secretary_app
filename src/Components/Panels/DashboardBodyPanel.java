package Components.Panels;

import Common.Employee;
import Components.EmployeeCard;
import Components.WrapLayout;
import Services.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DashboardBodyPanel extends JPanel
{
    private final CardLayout cardLayout = new CardLayout();
    private static final JPanel employeesPanel = new JPanel();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public DashboardBodyPanel()
    {
        employeesPanel.setLayout(new WrapLayout(WrapLayout.LEFT, 30 , 20));
        this.createPanel();
    }

    private void createPanel()
    {
        this.setLayout(this.cardLayout);

        JScrollPane employeesScrollPane = new JScrollPane(employeesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel subjectsPanel = new JPanel();
        JPanel studyGroupsPanel = new JPanel();

        repaintEmployeesPanel();

        this.add(employeesScrollPane, "employees");
        this.add(subjectsPanel, "subjects");
        this.add(studyGroupsPanel, "studyGroups");
        this.showBody("employees");
    }

    public void showBody(String name)
    {
        this.cardLayout.show(this, name);
    }

    private static void prepareEmployeesContent()
    {
        employeesPanel.removeAll();
        employees = new ArrayList<>();
        employees = DBConnection.getInstance().getAllEmployees();
    }

    public static void repaintEmployeesPanel()
    {
        prepareEmployeesContent();

        for (Employee employee : employees)
            employeesPanel.add(new EmployeeCard(employee,10, Color.white));

        employeesPanel.revalidate();
    }
}
