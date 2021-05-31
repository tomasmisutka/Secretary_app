package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardWorkLabelsPanel extends JPanel
{
    private boolean isVisible = true;
    private final static DashboardWorkLabelsPanel labelsPanel = new DashboardWorkLabelsPanel();

    private DashboardWorkLabelsPanel()
    {
        this.createPanel();
    }

    public static DashboardWorkLabelsPanel getLabelsPanel()
    {
        if (labelsPanel == null)
            return new DashboardWorkLabelsPanel();
        return labelsPanel;
    }

    private void createPanel()
    {
        this.setBorder(new EmptyBorder(10, 5, 10, 5));
        this.setBackground(Color.red);
        this.setVisible(isVisible);
    }

    public void changeVisibility()
    {
        this.isVisible = !this.isVisible;
        this.createPanel();
    }
}
