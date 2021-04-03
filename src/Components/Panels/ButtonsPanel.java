package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener
{
    private final JButton enter;
    private final JButton exit;

    public ButtonsPanel()
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
            System.out.println("enter button pressed");
    }

    private void showDialog()
    {
        int result = JOptionPane.showConfirmDialog(this,"Are you sure?", "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
