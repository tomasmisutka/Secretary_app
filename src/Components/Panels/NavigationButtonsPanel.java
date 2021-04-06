package Components.Panels;

import Components.NavigationAddButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationButtonsPanel extends JPanel implements ActionListener
{
    private final NavigationAddButton addEmployeeButton;
    private final NavigationAddButton addSubjectButton;
    private final NavigationAddButton addStudyGroupButton;
    private final NavigationAddButton addWorkLabelButton;

    public NavigationButtonsPanel()
    {
        this.addEmployeeButton = new NavigationAddButton("add_employee.png", "Employee");
        this.addSubjectButton = new NavigationAddButton("add_subject.png", "Subject");
        this.addStudyGroupButton = new NavigationAddButton("add_class.png", "Study group");
        this.addWorkLabelButton = new NavigationAddButton("add_worklabel.png", "WorkLabel");
        this.createPanel();
        this.addActionsListeners();
    }

    private void addActionsListeners()
    {
        this.addEmployeeButton.addActionListener(this);
        this.addSubjectButton.addActionListener(this);
        this.addStudyGroupButton.addActionListener(this);
        this.addWorkLabelButton.addActionListener(this);
    }

    private void createPanel()
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setBackground(Color.white);
        this.setLayout(new GridBagLayout());
        this.add(this.addEmployeeButton, gridBagConstraints);
        this.add(this.addSubjectButton, gridBagConstraints);
        this.add(this.addStudyGroupButton, gridBagConstraints);
        this.add(this.addWorkLabelButton, gridBagConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.addEmployeeButton)
            System.out.println("Add employee form");
        if (e.getSource() == this.addSubjectButton)
            System.out.println("Add subject form");
        if (e.getSource() == this.addStudyGroupButton)
            System.out.println("Add study group form");
        if (e.getSource() == this.addWorkLabelButton)
            System.out.println("Add work label form");
    }
}
