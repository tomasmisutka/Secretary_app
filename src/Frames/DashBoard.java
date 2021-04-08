package Frames;

import Components.Panels.DashBoardNavigationPanel;
import Components.Panels.DashBoardSidePanelLeft;
import Components.Panels.WorkLabelsPanel;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame
{
    public DashBoard()
    {
        WorkLabelsPanel labelsPanel = new WorkLabelsPanel();
        this.initFrame(new DashBoardNavigationPanel(), new DashBoardSidePanelLeft(labelsPanel), labelsPanel);
    }

    private void initFrame(JPanel navigationPanel, JPanel leftPanel, JPanel workLabelsPanel)
    {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200, 900));
        this.setMinimumSize(new Dimension(1200, 900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panels
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(workLabelsPanel, BorderLayout.EAST);

        this.setVisible(true);
    }
}
