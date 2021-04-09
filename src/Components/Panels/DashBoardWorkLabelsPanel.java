package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashBoardWorkLabelsPanel extends JPanel
{
    private boolean isVisible = true;
    private final static DashBoardWorkLabelsPanel labelsPanel = new DashBoardWorkLabelsPanel();

    private DashBoardWorkLabelsPanel()
    {
        this.createPanel();
    }

    public static DashBoardWorkLabelsPanel getLabelsPanel()
    {
        if (labelsPanel == null)
            return new DashBoardWorkLabelsPanel();
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
