package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormTitlePanel extends JPanel
{
    private final String titleMessage;

    public FormTitlePanel(String titleMessage)
    {
        this.titleMessage = titleMessage;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(8, 20, 8, 0));
        JLabel titleLabel = new JLabel();
        titleLabel.setText(this.titleMessage);
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        titleLabel.setIcon(new ImageIcon("./src/Images/logo_50x50.jpg"));
        titleLabel.setIconTextGap(75);
        this.add(titleLabel, BorderLayout.WEST);
    }
}
