package Components.Panels;

import Common.Constants;
import Common.Enums.FormPanelType;
import Components.AddForms.AddEmployeeForm;
import Components.AddForms.AddStudyGroupForm;
import Components.AddForms.AddSubjectForm;
import Components.AddForms.AddWorkLabelForm;
import Components.MyDialog;
import Services.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFormButtonsPanel extends CommonRoundedPanel implements ActionListener
{
    private final JButton submitButton = new JButton("Submit");
    private final JButton cancelButton = new JButton("Cancel");
    private final FormPanelType formPanelType;
    private final JFrame parent;

    public AddFormButtonsPanel(FormPanelType formPanelType, JFrame parent)
    {
        super(Constants.secondaryColor, 10);
        this.formPanelType = formPanelType;
        this.parent = parent;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setSize(new Dimension(100, 100));
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(0, 0, 0, 0));

        this.submitButton.setPreferredSize(new Dimension(100, 30));
        this.cancelButton.setPreferredSize(new Dimension(100, 30));
        this.submitButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.add(this.submitButton, new GridBagConstraints());
        this.add(this.cancelButton, new GridBagConstraints());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.formPanelType == FormPanelType.Employee)
            this.employeeFormAction(e);
        if (this.formPanelType == FormPanelType.Subject)
            this.subjectFormAction(e);
        if (this.formPanelType == FormPanelType.Study_Group)
            this.studyGroupAction(e);
        if (this.formPanelType == FormPanelType.Work_Label)
            this.workLabelAction(e);
    }

    private void employeeFormAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
            this.parent.dispose();

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedEmployee = DBConnection.getInstance().sendEmployeeToDB(AddEmployeeForm.getNewEmployee());
            if (!isSuccessfulCreatedEmployee)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE EMPLOYEE TO DATABASE");
            else
                this.parent.dispose();
        }
    }

    private void subjectFormAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
            this.parent.dispose();

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendSubjectToDB(AddSubjectForm.getNewSubject());
            if (!isSuccessfulCreatedSubject)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE SUBJECT TO DATABASE");
            else
                this.parent.dispose();
        }
    }

    private void studyGroupAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
            this.parent.dispose();

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendStudyGroupToDB(AddStudyGroupForm.getNewStudyGroup());
            if (!isSuccessfulCreatedSubject)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE STUDY GROUP TO DATABASE");
            else
                this.parent.dispose();
        }
    }

    private void workLabelAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
            this.parent.dispose();

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendWorkLabelToDB(AddWorkLabelForm.getNewWorkLabel());
            if (!isSuccessfulCreatedSubject)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE WORK LABEL TO DATABASE");
            else
                this.parent.dispose();
        }
    }
}
