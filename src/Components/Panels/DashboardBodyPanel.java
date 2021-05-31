package Components.Panels;

import javax.swing.*;
import java.awt.*;

public class DashboardBodyPanel extends JPanel
{
    private final CardLayout cardLayout;
    public DashboardBodyPanel()
    {
        this.cardLayout = new CardLayout();
        this.createPanel();
    }

    private void createPanel()
    {
        this.setLayout(this.cardLayout);

        JPanel employeesPanel = new JPanel();
        JPanel subjectsPanel = new JPanel();
        JPanel studyGroupsPanel = new JPanel();

        employeesPanel.setBackground(Color.green);
        subjectsPanel.setBackground(Color.blue);
        studyGroupsPanel.setBackground(Color.magenta);

        this.add(employeesPanel, "employees");
        this.add(subjectsPanel, "subjects");
        this.add(studyGroupsPanel, "studyGroups");

        this.showBody("employees");
    }

    public void showBody(String name)
    {
        this.cardLayout.show(this, name);
    }
}
