package Components.Panels;

import Common.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashBoardSidePanelLeft extends JPanel
{
    private final WorkLabelsPanel labelsPanel;
    public DashBoardSidePanelLeft(WorkLabelsPanel panel)
    {
        this.labelsPanel = panel;
        this.createPanel();
    }

    private void createPanel()
    {
        this.setBackground(Constants.secondaryColor);
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(10,5,10,5));
        CommonRoundedPanel secretaryInfo = new CommonRoundedPanel(Color.white, 30);
        ButtonsLeftPanel middleButtons = new ButtonsLeftPanel(this.labelsPanel);
        this.setSecretaryInfoPanel(secretaryInfo);
        this.add(secretaryInfo, new GridBagConstraints(0,0,1,1,1.0,1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
        this.add(middleButtons, new GridBagConstraints(0,1,1,1,1.0,1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
    }

    private void setSecretaryInfoPanel(CommonRoundedPanel secretaryInfo)
    {
        secretaryInfo.setLayout(new GridBagLayout());
        secretaryInfo.setOpaque(false);
        secretaryInfo.setBorder(new EmptyBorder(50,20,50,20));
        JLabel secretaryLabel = new JLabel();
        secretaryLabel.setIcon(new ImageIcon("./src/Images/secretary.png"));
        secretaryLabel.setText("Secretary");
        secretaryLabel.setFont(new Font("Arial", Font.BOLD,25));
        secretaryInfo.add(secretaryLabel, new GridBagConstraints());
    }
}
