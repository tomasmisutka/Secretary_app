package Components;

import javax.swing.*;
import java.awt.*;

public class NavigationAddButton extends JButton
{
    private final String imagePath;
    private final String buttonText;

    public NavigationAddButton(String imageName, String buttonText)
    {
        this.imagePath = imageName;
        this.buttonText = buttonText;
        this.createButton();
    }

    private void createButton()
    {
        this.setText(this.buttonText);
        this.setFont(new Font("Arial", Font.ITALIC,12));
        this.setIcon(new ImageIcon("./src/Images/" + this.imagePath));
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(85,85));
        this.setIconTextGap(10);
    }
}
