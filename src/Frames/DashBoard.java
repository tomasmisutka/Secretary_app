package Frames;

import Components.Panels.DashBoardBodyPanel;
import Components.Panels.DashBoardNavigationPanel;
import Components.Panels.DashBoardSidePanelLeft;
import Components.Panels.DashBoardWorkLabelsPanel;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame
{
    public DashBoard()
    {
        DashBoardWorkLabelsPanel labelsPanel = new DashBoardWorkLabelsPanel();
        DashBoardBodyPanel bodyPanel = new DashBoardBodyPanel();
        this.initFrame(new DashBoardNavigationPanel(), new DashBoardSidePanelLeft(labelsPanel, bodyPanel),
                labelsPanel, bodyPanel);
    }

    private void initFrame(JPanel navigationPanel, JPanel leftPanel, JPanel workLabelsPanel, JPanel bodyPanel)
    {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200, 900));
        this.setMinimumSize(new Dimension(1200, 900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panels
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(workLabelsPanel, BorderLayout.EAST);
        this.add(bodyPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
