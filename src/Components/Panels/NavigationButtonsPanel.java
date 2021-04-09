package Components.Panels;

import Components.AddForms.AddEmployeeForm;
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
        this.addStudyGroupButton = new NavigationAddButton("add_class.png", "Study Group");
        this.addWorkLabelButton = new NavigationAddButton("add_worklabel.png", "Work Label");
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
        this.setBackground(Color.white);
        this.setLayout(new GridBagLayout());
        this.add(this.addEmployeeButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
        this.add(this.addSubjectButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
        this.add(this.addStudyGroupButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
        this.add(this.addWorkLabelButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.addEmployeeButton)
            AddEmployeeForm.getInstance();
        if (e.getSource() == this.addSubjectButton)
            System.out.println("Add subject form");
        if (e.getSource() == this.addStudyGroupButton)
            System.out.println("Add study group form");
        if (e.getSource() == this.addWorkLabelButton)
            System.out.println("Add work label form");
    }
}
