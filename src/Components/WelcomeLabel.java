package Components;

import javax.swing.*;
import java.awt.*;

public class WelcomeLabel extends JLabel
{
    public WelcomeLabel()
    {
        this.setIcon(new ImageIcon("./src/Images/logo.jpeg"));
        this.setText("Welcome to Secretary");
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setFont(new Font("Arial", Font.BOLD, 45));
    }
}
