package Frames;

import Components.Panels.*;
import dragNdrop.DropListener;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame
{
    private static Dashboard dashBoard = null;

    private Dashboard()
    {
        WorkLabelsPanel workLabelsPanel = WorkLabelsPanel.getInstance();
        StudyGroupsPanel studyGroupsPanel = StudyGroupsPanel.getInstance();
        ActionWrapperPanel actionWrapperPanel = new ActionWrapperPanel(workLabelsPanel, studyGroupsPanel);

        DashboardBodyPanel bodyPanel = new DashboardBodyPanel();
        new DropListener(bodyPanel);
        this.initFrame(new DashboardNavigationPanel(), new DashboardSidePanelLeft(bodyPanel, actionWrapperPanel),
                bodyPanel, actionWrapperPanel);
    }

    public static Dashboard getInstance()
    {
        if (dashBoard == null)
            dashBoard = new Dashboard();
        return dashBoard;
    }

    private void initFrame(JPanel navigationPanel, JPanel leftPanel, JPanel bodyPanel, JPanel actionWrapperPanel)
    {
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200, 750));
        this.setMinimumSize(new Dimension(1200, 750));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panels
        this.add(navigationPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(actionWrapperPanel, BorderLayout.EAST);
        this.add(bodyPanel, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
