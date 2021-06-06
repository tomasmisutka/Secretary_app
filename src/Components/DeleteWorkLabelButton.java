package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWorkLabelButton extends JButton implements ActionListener
{
    private final int id;

    public DeleteWorkLabelButton(int id)
    {
        this.id = id;
        this.createButton();
    }

    private void createButton()
    {
        this.setIcon(new ImageIcon("./src/Images/clear.png"));
        this.addActionListener(this);
        this.setPreferredSize(new Dimension(15,15));
        this.setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this))
            System.out.println("remove work label with id " + id + " from DB");
    }
}
