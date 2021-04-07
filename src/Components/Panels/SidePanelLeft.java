package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SidePanelLeft extends JPanel
{
    public SidePanelLeft()
    {
        this.createPanel();
    }

    private void createPanel()
    {
        this.setBackground(Color.black);
        CommonRoundedPanel secretaryInfo = new CommonRoundedPanel(Color.white, 25);
        this.setSecretaryInfoPanel(secretaryInfo);
        this.add(secretaryInfo);
    }

    private void setSecretaryInfoPanel(CommonRoundedPanel secretaryInfo)
    {
        secretaryInfo.setLayout(new GridBagLayout());
        secretaryInfo.setOpaque(false);
        secretaryInfo.setBorder(new EmptyBorder(50,20,50,20));
        JLabel secretaryLabel = new JLabel();
        secretaryLabel.setIcon(new ImageIcon("./src/Images/secretary.png"));
        secretaryLabel.setText("Mr. Secretary");
        secretaryLabel.setFont(new Font("Arial", Font.ITALIC,18));
        secretaryInfo.add(secretaryLabel, new GridBagConstraints());
    }
}
