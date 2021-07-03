package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardBodyPanel extends JPanel
{
    public static final String EMPLOYEES_CONSTRAINS = "employees";
    public static final String SUBJECTS_CONSTRAINS = "subjects";
    private final CardLayout cardLayout = new CardLayout();
    private final EmployeesPanel employeesPanel = EmployeesPanel.getInstance();
    private final SubjectPanel subjectPanel = SubjectPanel.getInstance();

    public DashboardBodyPanel()
    {
        this.createPanel();
    }

    private void createPanel()
    {
        this.setLayout(this.cardLayout);

        EmptyBorder emptyBorder = new EmptyBorder(0, 0, 0, 0);
        JScrollPane employeesScrollPane = new JScrollPane(employeesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        employeesScrollPane.setName(EMPLOYEES_CONSTRAINS);
        employeesScrollPane.setBorder(emptyBorder);
        JScrollPane subjectScrollPanel = new JScrollPane(subjectPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        subjectScrollPanel.setName(SUBJECTS_CONSTRAINS);
        subjectScrollPanel.setBorder(emptyBorder);

        this.add(employeesScrollPane, EMPLOYEES_CONSTRAINS);
        this.add(subjectScrollPanel, SUBJECTS_CONSTRAINS);
        this.showBody(EMPLOYEES_CONSTRAINS);
    }
    public void showBody(String name)
    {
        this.cardLayout.show(this, name);
    }
}
