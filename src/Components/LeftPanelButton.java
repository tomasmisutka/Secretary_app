package Components;

import javax.swing.*;
import java.awt.*;

public class LeftPanelButton extends JButton
{
    private final String imageName;
    private final String name;
    private final int gap;

    public LeftPanelButton(String imageName, String name, int gap)
    {
        this.imageName = imageName;
        this.name = name;
        this.gap = gap;
        this.initButton();
    }

    private void initButton()
    {
        this.setIcon(new ImageIcon("./src/Images/" + this.imageName));
        this.setHorizontalTextPosition(JButton.LEFT);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setText(this.name);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(250, 45));
        this.setIconTextGap(this.gap);

    }
}
