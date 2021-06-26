package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardBodyPanel extends JPanel
{
    private final CardLayout cardLayout = new CardLayout();
    private final EmployeesPanel employeesPanel = EmployeesPanel.getInstance();

    public DashboardBodyPanel()
    {
        this.createPanel();
    }

    private void createPanel()
    {
        this.setLayout(this.cardLayout);

        JScrollPane employeesScrollPane = new JScrollPane(employeesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        employeesScrollPane.setBorder(new EmptyBorder(0,0,0,0));
        JPanel subjectsPanel = new JPanel();
        JPanel studyGroupsPanel = new JPanel();

        this.add(employeesScrollPane, "employees");
        this.add(subjectsPanel, "subjects");
        this.add(studyGroupsPanel, "studyGroups");
        this.showBody("employees");
    }

    public void showBody(String name)
    {
        this.cardLayout.show(this, name);
    }
}
