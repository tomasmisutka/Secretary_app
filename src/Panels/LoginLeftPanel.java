package Panels;

import Components.AdaptedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginLeftPanel extends JPanel
{
    public LoginLeftPanel()
    {
        super();
        this.setLayout(new GridBagLayout());
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setPreferredSize(new Dimension(400,250));
        formPanel.setLayout(new GridBagLayout());

        Font labelsFont = new Font("Arial", Font.BOLD, 15);

        //email field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelsFont);
        JTextField usernameTextField = new JTextField();
        formPanel.add(usernameLabel, new GridBagConstraints(0,0,1,1,0.0,0.0,
                GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(5,10,5,5),0,0));
        formPanel.add(usernameTextField, new GridBagConstraints(1,0,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,10), 0,0));

        //password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelsFont);
        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordLabel, new GridBagConstraints(0,1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5,10,5,5), 0,0));
        formPanel.add(passwordField, new GridBagConstraints(1,1,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,10), 0,0));

        //buttons
        AdaptedButton loginButton = new AdaptedButton("Login",Color.green,Color.black);
        AdaptedButton closeButton = new AdaptedButton("Exit",Color.red,Color.white);
        AdaptedButton newUserButton = new AdaptedButton("Create new user",Color.orange,Color.black);

        formPanel.add(loginButton, new GridBagConstraints(0,2,1,1,0.5,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));
        formPanel.add(closeButton, new GridBagConstraints(1,2,1,1,0.5,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));
        formPanel.add(newUserButton, new GridBagConstraints(0,3,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));

        loginButton.addActionListener(this.loginButtonActionListener());
        closeButton.addActionListener(this.closeButtonActionListener());

        this.setBackground(Color.black);
        this.add(formPanel, new GridBagConstraints());
    }

    private ActionListener closeButtonActionListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        };
    }

    private ActionListener loginButtonActionListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("login process");
            }
        };
    }

    private ActionListener newUserButtonActionListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("create new user action listener");
            }
        };
    }
}
