package Components;

import Enums.LOGIN_BUTTON_TYPE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaptedButton extends JButton implements ActionListener
{
    LOGIN_BUTTON_TYPE type;
    public AdaptedButton(String text, LOGIN_BUTTON_TYPE type)
    {
        super();
        this.type = type;
        this.setText(text);
        this.setUpColor();
        this.setOpaque(true);
        this.addActionListener(this);
        this.setBorderPainted(false);
        this.setFont(new Font("Arial",Font.BOLD,16));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (this.type == LOGIN_BUTTON_TYPE.EXIT)
        {
            System.exit(0);
        }
        else if(this.type == LOGIN_BUTTON_TYPE.LOGIN)
        {
            System.out.println("LOGIN BUTTON pressed");
        }
        else {
            System.out.println("CREATE NEW BUTTON pressed");
        }
    }

    private void setUpColor()
    {
        if (this.type == LOGIN_BUTTON_TYPE.EXIT)
        {
            this.setBackground(Color.red);
        }
        else if (this.type == LOGIN_BUTTON_TYPE.LOGIN)
        {
            this.setBackground(Color.green);
        }
        else
        {
            this.setBackground(Color.orange);
        }
    }
}
