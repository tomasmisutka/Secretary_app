package Panels;

import javax.swing.*;
import java.awt.*;

public class LoginImagePanel extends JPanel
{
    public LoginImagePanel()
    {
        super();
        JLabel label = new JLabel();
        this.setLayout(new BorderLayout());
        label.setIcon(new ImageIcon("./src/Images/login_picture.jpg"));
        label.setPreferredSize(new Dimension(500,500));
        this.add(label, BorderLayout.CENTER);

    }
}
