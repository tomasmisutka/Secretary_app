package Components.Panels;

import Components.MessageDialog;
import Frames.Dashboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardNavigationPanel extends JPanel implements ActionListener
{
    private JButton leaveButton;

    public DashboardNavigationPanel()
    {
        this.createContent();
    }

    private void createContent()
    {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(this.getLogo(), BorderLayout.WEST);
        this.add(this.getLeaveButton(), BorderLayout.EAST);
        this.add(new NavigationButtonsPanel(), BorderLayout.CENTER);
    }

    private JLabel getLogo()
    {
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("./src/Images/logo_100x100.jpeg"));
        logo.setBorder(new EmptyBorder(15, 20, 15, 0));
        return logo;
    }

    private JButton getLeaveButton()
    {
        this.leaveButton = new JButton("LEAVE");
        this.leaveButton.setIcon(new ImageIcon("./src/Images/logout.png"));
        this.leaveButton.setFont(new Font("Arial", Font.ITALIC, 15));
        this.leaveButton.addActionListener(this);
        this.leaveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return leaveButton;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.leaveButton)
        {
            int result = MessageDialog.showConfirmationDialog(Dashboard.getInstance(), "Do you want to exit?");
            if (result == JOptionPane.YES_OPTION)
                System.exit(0);
        }

    }
}
