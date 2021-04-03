package Components.Panels;

import Common.WorkloadWeights;
import Components.MyDialog;
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

    public WelcomeButtonsPanel()
    {
        this.enter = new JButton("Enter");
        this.exit = new JButton("Exit");
        this.enter.addActionListener(this);
        this.exit.addActionListener(this);
        this.setBorder(new EmptyBorder(10, 0, 0, 0));
        this.setBackground(Color.black);
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
        WorkloadWeights workloadWeights = dbConnection.getWorkLoadWeights();
        if (workloadWeights == null)
            MyDialog.showErrorDialog(this, "DATABASE connection PROBLEM!!!");
        else
            System.out.println(workloadWeights);
    }

}
