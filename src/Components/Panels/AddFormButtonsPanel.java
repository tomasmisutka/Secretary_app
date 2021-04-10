package Components.Panels;

import Common.Constants;
import Common.Employee;
import Common.Enums.FormPanelType;
import Components.AddForms.AddEmployeeForm;
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
    private final AddEmployeeForm frame;
    private Employee employee;

    public AddFormButtonsPanel(FormPanelType formPanelType, AddEmployeeForm frame)
    {
        super(Constants.secondaryColor, 10);
        this.formPanelType = formPanelType;
        this.frame = frame;
        this.employee = new Employee();
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
        if (e.getSource() == this.cancelButton)
            this.frame.dispose();
        if (this.formPanelType == FormPanelType.Employee)
        {
            if (e.getSource() == this.submitButton)
            {
                this.employee = this.frame.getNewEmployee();
                DBConnection dbConnection = DBConnection.getDbConnection();
                boolean isSuccessfulCreatedEmployee = dbConnection.sendEmployeeToDB(this.employee);
                if (!isSuccessfulCreatedEmployee)
                    MyDialog.showErrorDialog(this, "CAN NOT INSERT THE EMPLOYEE TO DATABASE");
                else
                    this.frame.dispose();
            }
        }
    }
}
