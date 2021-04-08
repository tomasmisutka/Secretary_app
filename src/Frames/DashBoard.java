package Frames;

import Components.Panels.DashBoardNavigationPanel;
import Components.Panels.DashBoardSidePanelLeft;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame
{
    public DashBoard()
    {
        this.initFrame(new DashBoardNavigationPanel(), new DashBoardSidePanelLeft());
    }

    private void initFrame(JPanel navigationPanel, JPanel leftPanel)
    {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200,900));
        this.setMinimumSize(new Dimension(1200,900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panels
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);

        this.setVisible(true);
    }
}
