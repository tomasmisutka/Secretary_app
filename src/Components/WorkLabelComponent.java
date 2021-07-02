package Components;

import Common.Constants;
import Common.WorkLabel;
import Components.Panels.CommonRoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WorkLabelComponent extends CommonRoundedPanel
{
    private final WorkLabel workLabel;

    public WorkLabelComponent(WorkLabel workLabel)
    {
        super(Constants.secondaryColor, 15);
        this.workLabel = workLabel;
        this.initPanel();
    }

    private void initPanel()
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(3, 5, 3, 5));
        JLabel workLabelTitle = new JLabel(workLabel.getName());
        workLabelTitle.setForeground(Color.white);
        workLabelTitle.setFont(new Font("Arial", Font.ITALIC, 12));

        this.add(workLabelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.setMaximumSize(new Dimension(350, 30));
    }

    public WorkLabel getWorkLabel()
    {
        return workLabel;
    }
}
