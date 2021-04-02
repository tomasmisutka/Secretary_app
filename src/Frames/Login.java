package Frames;

import Panels.LoginImagePanel;
import Panels.LoginLeftPanel;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
    public Login()
    {
        super();
        this.initFrame(new LoginLeftPanel(), new LoginImagePanel());
    }

    private void initFrame(JPanel loginPanel, JPanel imagePanel)
    {
        this.setLayout(new GridBagLayout());
        Image appIcon = Toolkit.getDefaultToolkit().getImage("/Images/logo.jpeg");
        this.setIconImage(appIcon);

        //layout
        this.add(loginPanel, new GridBagConstraints(0,0,1,1,0.5,1.0,
                GridBagConstraints.WEST,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));
        this.add(imagePanel, new GridBagConstraints(1,0,1,1,0.5,1.0,
                GridBagConstraints.WEST,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Secretary");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}