package Components.Panels;

import Components.LeftPanelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsLeftPanel extends JPanel implements ActionListener
{
    private LeftPanelButton employeeButton;
    private LeftPanelButton studyGroupButton;
    private LeftPanelButton subjectButton;
    private LeftPanelButton workLabelButton;
    private final DashboardBodyPanel bodyPanel;
    private final ActionWrapperPanel actionWrapperPanel;
    private final WorkLabelsPanel workLabelsPanel = WorkLabelsPanel.getInstance();
    private final StudyGroupsPanel studyGroupsPanel = StudyGroupsPanel.getInstance();

    public ButtonsLeftPanel(DashboardBodyPanel bodyPanel, ActionWrapperPanel actionWrapperPanel)
    {
        this.bodyPanel = bodyPanel;
        this.actionWrapperPanel = actionWrapperPanel;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        employeeButton = new LeftPanelButton("button_employees.png", "Employees", 40);
        employeeButton.addActionListener(this);
        studyGroupButton = new LeftPanelButton("button_studyGroup.png", "Study Groups", 15);
        studyGroupButton.addActionListener(this);
        subjectButton = new LeftPanelButton("button_subject.png", "Subjects", 60);
        subjectButton.addActionListener(this);
        workLabelButton = new LeftPanelButton("button_workLabel.png", "Work Labels", 30);
        workLabelButton.addActionListener(this);

        this.add(employeeButton, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0));
        this.add(workLabelButton, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
        this.add(subjectButton, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        this.add(studyGroupButton, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.employeeButton)
        {
            bodyPanel.showBody(DashboardBodyPanel.EMPLOYEES_CONSTRAINS);
            actionWrapperPanel.changeContent(1);
        } else if (e.getSource() == this.studyGroupButton && this.getActiveBody().equals(DashboardBodyPanel.SUBJECTS_CONSTRAINS))
        {
            actionWrapperPanel.changeVisibility();
        } else if (e.getSource() == this.subjectButton)
        {
            bodyPanel.showBody(DashboardBodyPanel.SUBJECTS_CONSTRAINS);
            actionWrapperPanel.changeContent(2);
        } else if (e.getSource() == workLabelButton && this.getActiveBody().equals(DashboardBodyPanel.EMPLOYEES_CONSTRAINS))
            actionWrapperPanel.changeVisibility();

    }

    private String getActiveBody()
    {
        JScrollPane activePanel = null;
        for (Component component : bodyPanel.getComponents())
        {
            if (component.isVisible())
                activePanel = (JScrollPane) component;
        }
        return activePanel.getName();
    }

}
