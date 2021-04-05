package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashBoardNavigationPanel extends JPanel
{
    public DashBoardNavigationPanel()
    {
        this.createContent();
    }

    private void createContent()
    {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("./src/Images/logo_100x100.jpeg"));
        logo.setBorder(new EmptyBorder(15,20,15,0));
        this.add(logo, BorderLayout.WEST);
    }
}
