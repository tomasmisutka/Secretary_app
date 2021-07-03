package Components;

import Common.Constants;
import Common.StudyGroup;
import Components.Panels.CommonRoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StudyGroupComponent extends CommonRoundedPanel
{
    private final StudyGroup studyGroup;

    public StudyGroupComponent(StudyGroup studyGroup)
    {
        super(Constants.primaryColor, 15);
        this.setBorder(new EmptyBorder(3, 15, 3, 15));
        this.setLayout(new GridBagLayout());
        this.studyGroup = studyGroup;
        this.initComponent();
    }

    private void initComponent()
    {
        Font font = new Font("Arial", Font.ITALIC, 12);
        JLabel title = new JLabel();
        title.setText(studyGroup.getAbbreviation());
        title.setFont(font);
        title.setForeground(Constants.secondaryColor);
        this.add(title, new GridBagConstraints());
    }

    public StudyGroup getStudyGroup()
    {
        return this.studyGroup;
    }
}
