package Components;

import Common.Constants;
import Common.Employee;
import Common.Message;
import Common.WorkLabel;
import Components.AddForms.AddEmployeeForm;
import Components.Panels.EmployeesPanel;
import Services.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeeCard extends JPanel implements ActionListener
{
    private final Employee employee;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JButton sendEmailButton;
    private static JPanel assignedWorkLabelsPanel;
    private final JLabel employeeFullName = new JLabel();
    private static ArrayList<WorkLabel> employeeWorkLabels = new ArrayList<>();

    public EmployeeCard(Employee employee)
    {
        this.employee = employee;
        this.editButton = new JButton();
        this.deleteButton = new JButton();
        this.sendEmailButton = new JButton();
        this.initCard();
    }

    private void initCard()
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(200, 245));

        this.add(this.getTitlePanel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.getWorkLabelsAssignedPanel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.getEditionPanel(), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.getSendEmailPanel(), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    private JPanel getTitlePanel()
    {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(Color.white);
        titlePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.secondaryColor),
                new EmptyBorder(5, 0, 5, 0)
        ));

        this.setEmployeeFullName(employee);
        titlePanel.add(employeeFullName, new GridBagConstraints());
        return titlePanel;
    }

    private void setEmployeeFullName(Employee employee)
    {
        Font titleFont = new Font("Arial", Font.BOLD, 15);
        employeeFullName.setText(employee.getLastName() + " " +
                employee.getFirstName().toUpperCase().charAt(0) + ".");
        employeeFullName.setFont(titleFont);
        employeeFullName.setForeground(Constants.secondaryColor);
    }


    private JScrollPane getWorkLabelsAssignedPanel()
    {
        assignedWorkLabelsPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(assignedWorkLabelsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        assignedWorkLabelsPanel.setBackground(Color.white);
        assignedWorkLabelsPanel.setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));

        employeeWorkLabels = DBConnection.getInstance().getWorkLabelsAssignedToEmployee(employee.getId());

        for (WorkLabel workLabel : employeeWorkLabels)
        {
            WorkLabelComponent workLabelComponent = new WorkLabelComponent(workLabel);
            assignedWorkLabelsPanel.add(workLabelComponent);
        }
        return scrollPane;
    }

    public static void releaseWorkLabelFromEmployee(WorkLabelComponent workLabelToRelease)
    {
        assignedWorkLabelsPanel.remove(workLabelToRelease);
        employeeWorkLabels.remove(workLabelToRelease.getWorkLabel());
        assignedWorkLabelsPanel.revalidate();
        assignedWorkLabelsPanel.repaint();
    }

    private JPanel getEditionPanel()
    {
        JPanel editionPanel = new JPanel();
        editionPanel.setBackground(Color.white);
        editionPanel.setLayout(new GridBagLayout());
        editionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Constants.secondaryColor),
                new EmptyBorder(5, 0, 3, 0)
        ));

        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editButton.setText("edit");
        editButton.addActionListener(this);

        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.setText("delete");
        deleteButton.addActionListener(this);

        editionPanel.add(editButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        editionPanel.add(deleteButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        return editionPanel;
    }

    private JPanel getSendEmailPanel()
    {
        JPanel emailPanel = new JPanel();
        emailPanel.setBackground(Constants.primaryColor);
        emailPanel.setLayout(new GridBagLayout());

        sendEmailButton.setForeground(Color.black);
        sendEmailButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendEmailButton.setFont(new Font("Arial", Font.BOLD, 13));
        sendEmailButton.setText("Send email");
        sendEmailButton.setBorderPainted(false);
        sendEmailButton.setContentAreaFilled(false);
        sendEmailButton.setFocusPainted(false);
        sendEmailButton.setOpaque(false);

        emailPanel.add(sendEmailButton, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        return emailPanel;
    }

    public Employee getEmployee()
    {
        return this.employee;
    }

    public void updateEmployeeName(Employee employee)
    {
        this.setEmployeeFullName(employee);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == editButton)
        {
            if (AddEmployeeForm.getInstancesCounter() < 1)
                new AddEmployeeForm(true, employee.getId());
        } else if (e.getSource() == deleteButton)
        {
            int confirmationDelete = MessageDialog.showConfirmationDialog(null,
                    Message.CONFIRM_REMOVE_EMPLOYEE + employee.getFullName() + " ?");
            if (confirmationDelete == JOptionPane.YES_OPTION)
                EmployeesPanel.getInstance().deleteEmployee(this);
        }

    }
}
