package Frames;

import Components.Panels.DashboardBodyPanel;
import Components.Panels.DashboardNavigationPanel;
import Components.Panels.DashboardSidePanelLeft;
import Components.Panels.DashboardWorkLabelsPanel;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame
{
    private static Dashboard dashBoard = null;

    private Dashboard()
    {
        DashboardWorkLabelsPanel labelsPanel = DashboardWorkLabelsPanel.getLabelsPanel();
        DashboardBodyPanel bodyPanel = new DashboardBodyPanel();
        this.initFrame(new DashboardNavigationPanel(), new DashboardSidePanelLeft(bodyPanel),
                labelsPanel, bodyPanel);
    }

    public static Dashboard getInstance()
    {
        if (dashBoard == null)
            dashBoard = new Dashboard();
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
