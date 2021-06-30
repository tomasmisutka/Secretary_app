package Components.Panels;

import Common.Constants;
import Common.Employee;
import Common.Enums.FormPanelType;
import Common.Message;
import Components.AddForms.AddEmployeeForm;
import Components.AddForms.AddStudyGroupForm;
import Components.AddForms.AddSubjectForm;
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
    private final boolean editMode;

    public FormConfirmationsPanel(FormPanelType formPanelType, JFrame parent, boolean editMode)
    {
        super(Constants.secondaryColor, 10);
        this.formPanelType = formPanelType;
        this.parent = parent;
        this.editMode = editMode;
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
        else if (this.formPanelType == FormPanelType.Subject)
            this.subjectFormAction(e);
        else
            this.studyGroupAction(e);
    }

    private void employeeFormAction(ActionEvent e)
    {
        if (e.getSource() == this.cancelButton)
        {
            AddEmployeeForm.releaseInstance();
            this.parent.dispose();
        } else if (e.getSource() == this.submitButton)
        {
            boolean success;
            if (editMode)
            {
                Employee newEmployee = AddEmployeeForm.getEmployee();
                success = EmployeesPanel.getInstance().updateEmployee(newEmployee);
                if (success)
                    success = EmployeesPanel.getInstance().revalidateAfterUpdate(newEmployee);
            } else
                success = EmployeesPanel.getInstance().addNewEmployee(AddEmployeeForm.getEmployee());

            if (!success)
                MessageDialog.showErrorDialog(this, Message.DB_EMPLOYEE_ERROR);
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
        } else if (e.getSource() == this.submitButton)
        {
            //todo - here will be called nor dbConnection but Subject panel instead
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendSubjectToDB(AddSubjectForm.getNewSubject());
            if (!isSuccessfulCreatedSubject)
                MessageDialog.showErrorDialog(this, Message.DB_SUBJECT_ERROR);
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
        } else if (e.getSource() == this.submitButton)
        {
            //todo - here will be call not dbConnection but study group panel
            boolean isSuccessfulCreatedSubject = DBConnection.getInstance().sendStudyGroupToDB(AddStudyGroupForm.getNewStudyGroup());
            if (!isSuccessfulCreatedSubject)
                MessageDialog.showErrorDialog(this, Message.DB_STUDY_GROUP_ERROR);
            else
            {
                AddStudyGroupForm.releaseInstance();
                this.parent.dispose();
            }
        }
    }
}
