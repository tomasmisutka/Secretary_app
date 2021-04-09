package Components.AddForms;

import Common.Enums.FormPanelType;
import Components.Panels.AddFormButtonsPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEmployeeForm extends JFrame
{
    private static AddEmployeeForm addEmployeeForm = null;

    private AddEmployeeForm()
    {
        this.createContent();
    }

    public static AddEmployeeForm getInstance()
    {
        if (addEmployeeForm == null)
            return new AddEmployeeForm();
        return addEmployeeForm;
    }

    private void createContent()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        JPanel titlePanel = new JPanel();
        JPanel dataPanel = new JPanel();
        AddFormButtonsPanel buttonsPanel = new AddFormButtonsPanel(FormPanelType.Employee, this);

        this.initTitlePanel(titlePanel);
        this.initDataPanel(dataPanel);

        mainPanel.add(titlePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(dataPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(buttonsPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        this.add(mainPanel);
        this.setSize(new Dimension(400, 450));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initTitlePanel(JPanel northPanel)
    {
        northPanel.setBackground(Color.white);
        northPanel.setLayout(new BorderLayout());
        northPanel.setBorder(new EmptyBorder(8, 20, 8, 0));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Add new employee");
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        titleLabel.setIcon(new ImageIcon("./src/Images/logo_50x50.jpg"));
        titleLabel.setIconTextGap(75);
        northPanel.add(titleLabel, BorderLayout.WEST);
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

        JTextField firstNameTextField = new JTextField("Name");
        JTextField lastNameTextField = new JTextField("Surname");
        JTextField privateEmailTextField = new JTextField("example@gmail.com");
        JTextField jobEmailTextField = new JTextField("secretary@utb.cz");

        ButtonGroup doctoralGroup = new ButtonGroup();
        JRadioButton isDoctoralYes = new JRadioButton("Yes");
        JRadioButton isDoctoralNo = new JRadioButton("No");
        //TODO set-up no radio button as active
        isDoctoralYes.setFont(contentFont);
        isDoctoralNo.setFont(contentFont);
        doctoralGroup.add(isDoctoralYes);
        doctoralGroup.add(isDoctoralNo);

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
        dataPanel.add(isDoctoralYes, new GridBagConstraints(1, 4, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(isDoctoralNo, new GridBagConstraints(2, 4, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
    }
}
