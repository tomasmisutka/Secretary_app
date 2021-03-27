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

    private void initFrame(JPanel leftPanel, JPanel imagePanel)
    {
        this.setLayout(new GridBagLayout());
        Image appIcon = Toolkit.getDefaultToolkit().getImage("../images/logo.jpeg");
        this.setIconImage(appIcon);
        this.add(leftPanel, new GridBagConstraints(0,0,1,1,0.5,1.0,
                GridBagConstraints.WEST,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));
        this.add(imagePanel, new GridBagConstraints(1,0,1,1,0.5,1.0,
                GridBagConstraints.WEST,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,650));
        this.setVisible(true);
    }
}