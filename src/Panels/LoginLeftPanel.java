package Panels;

import Components.AdaptedButton;
import Enums.LOGIN_BUTTON_TYPE;

import javax.swing.*;
import java.awt.*;

public class LoginLeftPanel extends JPanel
{
    public LoginLeftPanel()
    {
        super();
        this.initPanel();
    }

    private void initPanel()
    {
        this.setLayout(new GridBagLayout());
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setPreferredSize(new Dimension(400,250));
        formPanel.setLayout(new GridBagLayout());

        Font labelsFont = new Font("Arial", Font.BOLD, 15);

        //email field
        JLabel usernameLabel = new JLabel();
        usernameLabel.setIcon(new ImageIcon(getClass().getResource("/images/username.png")));
        usernameLabel.setFont(labelsFont);
        JTextField usernameTextField = new JTextField();
        formPanel.add(usernameLabel, new GridBagConstraints(0,0,1,1,0.0,0.0,
                GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(5,10,5,5),0,0));
        formPanel.add(usernameTextField, new GridBagConstraints(1,0,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,10), 0,0));

        //password field
        JLabel passwordLabel = new JLabel();
        passwordLabel.setIcon(new ImageIcon(getClass().getResource("/images/password.png")));
        passwordLabel.setFont(labelsFont);
        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordLabel, new GridBagConstraints(0,1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5,10,5,5), 0,0));
        formPanel.add(passwordField, new GridBagConstraints(1,1,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,10), 0,0));

        //buttons
        AdaptedButton loginButton = new AdaptedButton("Login", LOGIN_BUTTON_TYPE.LOGIN);
        AdaptedButton closeButton = new AdaptedButton("Exit", LOGIN_BUTTON_TYPE.EXIT);
        AdaptedButton newUserButton = new AdaptedButton("Create new user", LOGIN_BUTTON_TYPE.CREATE_NEW_ONE);

        formPanel.add(loginButton, new GridBagConstraints(0,2,1,1,0.5,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));
        formPanel.add(closeButton, new GridBagConstraints(1,2,1,1,0.5,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));
        formPanel.add(newUserButton, new GridBagConstraints(0,3,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0));

        this.setBackground(Color.black);
        this.add(formPanel, new GridBagConstraints());
    }
}
