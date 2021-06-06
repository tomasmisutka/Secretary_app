package Components;

import Common.Constants;
import Common.Employee;
import Components.Panels.CommonRoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCard extends CommonRoundedPanel implements ActionListener
{
    private int radius;
    private Color color;
    private final Employee employee;
    private final JButton editButton;
    private final JButton deleteButton;

    public EmployeeCard(Employee employee, int radius, Color color)
    {
        super(color, radius);
        this.employee = employee;
        this.editButton = new JButton();
        this.deleteButton = new JButton();
        this.initCard();
    }

    private void initCard()
    {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(200,200));

        this.add(this.getTitlePanel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    private JPanel getTitlePanel()
    {
        CommonRoundedPanel titlePanel = new CommonRoundedPanel(Color.white,10);
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(Color.white);
        titlePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,0,2,0, Constants.secondaryColor),
                new EmptyBorder(15,0,15,0)
        ));
        Font titleFont = new Font("Arial", Font.BOLD, 15);

        JLabel employeeFullName = new JLabel(this.employee.getLastName() + " " +
                this.employee.getFirstName().toUpperCase().charAt(0) + ".");
        employeeFullName.setFont(titleFont);
        employeeFullName.setForeground(Constants.secondaryColor);

        //todo - this buttons you can use in another panel
//        int buttonSize = 40;
//
//        this.editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        this.editButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
//        this.editButton.setBackground(Color.orange);
//        this.editButton.setOpaque(true);
//        this.editButton.setIcon(new ImageIcon("./src/Images/edit.png"));
//
//        this.deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        this.deleteButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
//        this.deleteButton.setBackground(Color.red);
//        this.deleteButton.setOpaque(true);
//        this.deleteButton.setIcon(new ImageIcon("./src/Images/edit.png"));

        titlePanel.add(employeeFullName, new GridBagConstraints());
        return titlePanel;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
