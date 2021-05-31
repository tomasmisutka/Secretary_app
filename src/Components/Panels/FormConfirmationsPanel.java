package Components.Panels;

import Common.Constants;
import Common.Enums.FormPanelType;
import Components.AddForms.AddEmployeeForm;
import Components.AddForms.AddStudyGroupForm;
import Components.AddForms.AddSubjectForm;
import Components.AddForms.AddWorkLabelForm;
import Components.MessageDialog;
import Services.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormConfirmationsPanel extends CommonRoundedPanel implements ActionListener
{
    private final JButton submitButton = new JButton("Submit");
    private final JButton cancelButton = new JButton("Cancel");
    private final FormPanelType formPanelType;
    private final JFrame parent;

    public FormConfirmationsPanel(FormPanelType formPanelType, JFrame parent)
    {
        super(Constants.secondaryColor, 10);
        this.formPanelType = formPanelType;
        this.parent = parent;
        this.createPanel();
    }

    private void createPanel()
    {
        int buttonWidth = 100;
        int buttonHeight = 30;

        this.setSize(new Dimension(100, 100));
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(0, 0, 0, 0));

        this.submitButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        this.cancelButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
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
        {
            AddEmployeeForm.releaseInstance();
            this.parent.dispose();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedEmployee = DBConnection.getInstance().sendEmployeeToDB(AddEmployeeForm.getNewEmployee());
            if (!isSuccessfulCreatedEmployee)
                MessageDialog.showErrorDialog(this, "CAN NOT INSERT THE EMPLOYEE TO DATABASE");
            else
            {
                AddEmployeeForm.releaseInstance();
                this.parent.dispose();
            }
        }
    }

    private void subjectFormAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
        {
            AddSubjectForm.releaseInstance();
            this.parent.dispose();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendSubjectToDB(AddSubjectForm.getNewSubject());
            if (!isSuccessfulCreatedSubject)
                MessageDialog.showErrorDialog(this, "CAN NOT INSERT THE SUBJECT TO DATABASE");
            else
            {
                AddSubjectForm.releaseInstance();
                this.parent.dispose();
            }
        }
    }

    private void studyGroupAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
        {
            AddStudyGroupForm.releaseInstance();
            this.parent.dispose();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendStudyGroupToDB(AddStudyGroupForm.getNewStudyGroup());
            if (!isSuccessfulCreatedSubject)
                MessageDialog.showErrorDialog(this, "CAN NOT INSERT THE STUDY GROUP TO DATABASE");
            else
            {
                AddStudyGroupForm.releaseInstance();
                this.parent.dispose();
            }
        }
    }

    private void workLabelAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
        {
            AddWorkLabelForm.releaseInstance();
            this.parent.dispose();
        }

        if (e.getSource() == this.submitButton)
        {
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendWorkLabelToDB(AddWorkLabelForm.getNewWorkLabel());
            if (!isSuccessfulCreatedSubject)
                MessageDialog.showErrorDialog(this, "CAN NOT INSERT THE WORK LABEL TO DATABASE");
            else
            {
                AddWorkLabelForm.releaseInstance();
                this.parent.dispose();
            }
        }
    }
}
