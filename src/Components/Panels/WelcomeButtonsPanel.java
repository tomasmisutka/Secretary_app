package Components.Panels;

import Common.Constants;
import Common.GlobalConfig;
import Components.MyDialog;
import Frames.DashBoard;
import Services.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeButtonsPanel extends JPanel implements ActionListener
{
    private final JButton enter;
    private final JButton exit;
    private final JFrame welcomeScreen;

    public WelcomeButtonsPanel(JFrame welcomeScreen)
    {
        this.enter = new JButton("Enter");
        this.exit = new JButton("Exit");
        this.welcomeScreen = welcomeScreen;
        this.enter.addActionListener(this);
        this.exit.addActionListener(this);
        this.setBorder(new EmptyBorder(10, 0, 0, 0));
        this.setBackground(Constants.secondaryColor);
        this.setPreferredSize(new Dimension(600, 60));
        this.add(enter);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.exit)
            this.showDialog();
        if (e.getSource() == this.enter)
            this.continueToDashBoard();
    }

    private void showDialog()
    {
        int result = MyDialog.showConfirmationDialog(this, "Are you sure? You will exit this app...");
        if (result == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    private void continueToDashBoard()
    {
        DBConnection dbConnection = new DBConnection();
        GlobalConfig globalConfig = dbConnection.getGlobalConfig();
        if (globalConfig == null)
            MyDialog.showErrorDialog(this, "DATABASE connection PROBLEM!!!");
        else
        {
            this.welcomeScreen.dispose();
            new DashBoard();
        }
    }

}
