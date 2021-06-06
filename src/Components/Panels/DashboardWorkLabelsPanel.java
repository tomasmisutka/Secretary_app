package Components.Panels;

import Common.Constants;
import Common.WorkLabel;
import Components.DeleteWorkLabelButton;
import Services.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

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
        return labelsPanel;
    }

    private void createPanel()
    {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(isVisible);
        this.initContent();
    }

    public void changeVisibility()
    {
        isVisible = !isVisible;
        this.setVisible(isVisible);
        this.revalidate();
    }

    private void initContent()
    {
        ArrayList<WorkLabel> workLabels = DBConnection.getInstance().getAllWorkLabels();

        for (WorkLabel workLabel : workLabels)
        {
            CommonRoundedPanel workLabelPanel = new CommonRoundedPanel(Constants.secondaryColor, 15);
            workLabelPanel.setLayout(new GridBagLayout());
            workLabelPanel.setBorder(new EmptyBorder(3, 5, 3, 5));

            JLabel workLabelTitle = new JLabel(workLabel.getName());
            workLabelTitle.setForeground(Color.white);
            workLabelTitle.setFont(new Font("Arial", Font.ITALIC, 12));
            workLabelPanel.add(workLabelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

            DeleteWorkLabelButton removeButton = new DeleteWorkLabelButton(workLabel.getId());
            workLabelPanel.add(removeButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));

            workLabelPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            workLabelPanel.setMaximumSize(new Dimension(300, 30));

            this.add(workLabelPanel);
            if (!(workLabels.indexOf(workLabel) == (workLabels.size() - 1)))
                this.add(Box.createVerticalStrut(10));
        }
    }
}
