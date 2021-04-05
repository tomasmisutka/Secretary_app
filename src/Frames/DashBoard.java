package Frames;

import Components.Panels.DashBoardNavigationPanel;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame
{
    public DashBoard()
    {
        this.initFrame(new DashBoardNavigationPanel());
    }

    private void initFrame(JPanel navigationPanel)
    {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200,900));
        this.setMinimumSize(new Dimension(1200,900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panels add
        this.add(navigationPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }
}
