package Components;

import javax.swing.*;
import java.awt.*;

public class AdaptedButton extends JButton
{
    public AdaptedButton(String text, Color backgroundColor, Color foregroundColor)
    {
        super();
        this.setText(text);
        this.setBackground(backgroundColor);
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setForeground(foregroundColor);
        this.setFont(new Font("Arial",Font.BOLD,16));
    }
}
