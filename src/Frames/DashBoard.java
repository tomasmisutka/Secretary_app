package Frames;

import Components.Panels.DashBoardBodyPanel;
import Components.Panels.DashBoardNavigationPanel;
import Components.Panels.DashBoardSidePanelLeft;
import Components.Panels.DashBoardWorkLabelsPanel;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame
{
    private static DashBoard dashBoard = null;

    private DashBoard()
    {
        DashBoardWorkLabelsPanel labelsPanel = DashBoardWorkLabelsPanel.getLabelsPanel();
        DashBoardBodyPanel bodyPanel = new DashBoardBodyPanel();
        this.initFrame(new DashBoardNavigationPanel(), new DashBoardSidePanelLeft(bodyPanel),
                labelsPanel, bodyPanel);
    }

    public static DashBoard getInstance()
    {
        if (dashBoard == null)
            dashBoard = new DashBoard();
        return dashBoard;
    }

    private void initFrame(JPanel navigationPanel, JPanel leftPanel, JPanel workLabelsPanel, JPanel bodyPanel)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200, 750));
        this.setMinimumSize(new Dimension(1200, 750));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panels
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(workLabelsPanel, BorderLayout.EAST);
        this.add(bodyPanel, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
