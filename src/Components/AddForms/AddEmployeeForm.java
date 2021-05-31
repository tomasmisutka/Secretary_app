package Components.AddForms;

import Common.Constants;
import Common.Employee;
import Common.Enums.FormPanelType;
import Components.Panels.FormConfirmationsPanel;
import Components.Panels.FormTitlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEmployeeForm extends JFrame
{
    private static int numberOfInstances = 0;
    private static final JTextField firstNameTextField = new JTextField("Name");
    private static final JTextField lastNameTextField = new JTextField("Surname");
    private static final JTextField privateEmailTextField = new JTextField("example@gmail.com");
    private static final JTextField jobEmailTextField = new JTextField("secretary@utb.cz");
    private static final ButtonGroup doctoralGroup = new ButtonGroup();

    public AddEmployeeForm()
    {
        this.createContent();
    }

    public static int getInstancesCounter()
    {
        return numberOfInstances;
    }

    public static void releaseInstance()
    {
        numberOfInstances = 0;
    }

    private void createContent()
    {
        numberOfInstances++;
        this.setLayout(new GridBagLayout());
        FormTitlePanel titlePanel = new FormTitlePanel("Add new employee");
        JPanel dataPanel = new JPanel();
        FormConfirmationsPanel buttonsPanel = new FormConfirmationsPanel(FormPanelType.Employee, this);

        this.initDataPanel(dataPanel);

        this.add(titlePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(dataPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        this.add(buttonsPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        this.setSize(new Dimension(400, 450));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initDataPanel(JPanel dataPanel)
    {
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(new EmptyBorder(10, 5, 10, 5));

        Font contentFont = new Font("Arial", Font.ITALIC, 15);

        JLabel firstNameLabel = new JLabel("Name:");
        firstNameLabel.setFont(contentFont);
        JLabel lastNameLabel = new JLabel("Surname:");
        lastNameLabel.setFont(contentFont);
        JLabel privateEmailLabel = new JLabel("Private email:");
        privateEmailLabel.setFont(contentFont);
        JLabel jobEmailLabel = new JLabel("Job email:");
        jobEmailLabel.setFont(contentFont);
        JLabel isDoctoralLabel = new JLabel("Is doctoral:");
        isDoctoralLabel.setFont(contentFont);

        JRadioButton isDoctoralYes = new JRadioButton(Constants.yesButtonText);
        JRadioButton isDoctoralNo = new JRadioButton(Constants.noButtonText);
        isDoctoralYes.setActionCommand(Constants.yesButtonText);
        isDoctoralNo.setActionCommand(Constants.noButtonText);
        isDoctoralYes.setFont(contentFont);
        isDoctoralNo.setFont(contentFont);
        doctoralGroup.add(isDoctoralYes);
        doctoralGroup.add(isDoctoralNo);
        doctoralGroup.setSelected(isDoctoralNo.getModel(), true);

        dataPanel.add(firstNameLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(firstNameTextField, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(lastNameLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(lastNameTextField, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(privateEmailLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(privateEmailTextField, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(jobEmailLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(jobEmailTextField, new GridBagConstraints(1, 3, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(isDoctoralLabel, new GridBagConstraints(0, 4, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(isDoctoralYes, new GridBagConstraints(1, 4, 1, 1, 0.1, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(isDoctoralNo, new GridBagConstraints(2, 4, 1, 1, 0.1, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
    }

    public static Employee getNewEmployee()
    {
        Employee employee = new Employee();

        String name = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        boolean isDoctoral = doctoralGroup.getSelection().getActionCommand().equals("YES");

        employee.setFirstName(name);
        employee.setLastName(lastName);
        employee.setFullName(name + " " + lastName);
        employee.setPrivateEmail(privateEmailTextField.getText());
        employee.setJobEmail(jobEmailTextField.getText());
        employee.setDoctoral(isDoctoral);
        employee.setWorkLoad(0);
        employee.setWorkPoints(0);
        employee.setWorkPointsEN(0);
        return employee;
    }
}
