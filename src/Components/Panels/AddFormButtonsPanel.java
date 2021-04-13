package Components.Panels;

import Common.Constants;
import Common.Enums.FormPanelType;
import Components.AddForms.AddEmployeeForm;
import Components.AddForms.AddStudyGroupForm;
import Components.AddForms.AddSubjectForm;
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

    public AddFormButtonsPanel(FormPanelType formPanelType)
    {
        super(Constants.secondaryColor, 10);
        this.formPanelType = formPanelType;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setSize(new Dimension(100, 100));
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(5, 0, 5, 0));

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
    }

    private void employeeFormAction(ActionEvent e)
    {
        AddEmployeeForm employeeForm = AddEmployeeForm.getInstance();
        if (e.getSource() == this.cancelButton)
        {
            employeeForm.dispose();
            AddEmployeeForm.setEmployeeFormAsNull();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedEmployee = DBConnection.getDbConnection().sendEmployeeToDB(employeeForm.getNewEmployee());
            if (!isSuccessfulCreatedEmployee)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE EMPLOYEE TO DATABASE");
            else
            {
                employeeForm.dispose();
                AddEmployeeForm.setEmployeeFormAsNull();
            }
        }
    }

    private void subjectFormAction(ActionEvent e)
    {
        AddSubjectForm subjectForm = AddSubjectForm.getInstance();
        if (e.getSource() == this.cancelButton)
        {
            subjectForm.dispose();
            AddSubjectForm.setSubjectFormAsNull();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getDbConnection().sendSubjectToDB(subjectForm.getNewSubject());
            if (!isSuccessfulCreatedSubject)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE SUBJECT TO DATABASE");
            else
            {
                subjectForm.dispose();
                AddSubjectForm.setSubjectFormAsNull();
            }
        }
    }

    private void studyGroupAction(ActionEvent e)
    {
        AddStudyGroupForm studyGroupForm = AddStudyGroupForm.getInstance();
        if (e.getSource() == this.cancelButton)
        {
            studyGroupForm.dispose();
            AddStudyGroupForm.setStudyGroupFormAsNull();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getDbConnection().sendStudyGroupToDB(studyGroupForm.getNewStudyGroup());
            if (!isSuccessfulCreatedSubject)
                MyDialog.showErrorDialog(this, "CAN NOT INSERT THE STUDY GROUP TO DATABASE");
            else
            {
                studyGroupForm.dispose();
                AddSubjectForm.setSubjectFormAsNull();
            }
        }
    }
}
