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
    private final DashBoardBodyPanel bodyPanel;

    public ButtonsLeftPanel(DashBoardBodyPanel bodyPanel)
    {
        this.bodyPanel = bodyPanel;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        this.employeeButton = new LeftPanelButton("button_employees.png", "Employees", 40);
        this.employeeButton.addActionListener(this);
        this.studyGroupButton = new LeftPanelButton("button_studyGroup.png", "Study Groups", 15);
        this.studyGroupButton.addActionListener(this);
        this.subjectButton = new LeftPanelButton("button_subject.png", "Subjects", 60);
        this.subjectButton.addActionListener(this);
        this.workLabelButton = new LeftPanelButton("button_workLabel.png", "Work Labels", 30);
        this.workLabelButton.addActionListener(this);

        this.add(this.employeeButton, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0));
        this.add(this.subjectButton, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        this.add(this.studyGroupButton, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        this.add(this.workLabelButton, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.employeeButton)
            this.bodyPanel.showBody("employees");
        if (e.getSource() == this.studyGroupButton)
            this.bodyPanel.showBody("subjects");
        if (e.getSource() == this.subjectButton)
            this.bodyPanel.showBody("studyGroups");
        if (e.getSource() == this.workLabelButton)
        {
            DashBoardWorkLabelsPanel labelsPanel = DashBoardWorkLabelsPanel.getLabelsPanel();
            labelsPanel.changeVisibility();
        }
    }
}
