package Components.Panels;

import Common.Constants;
import Common.StudyGroup;
import Common.Subject;
import Components.StudyGroupComponent;
import Services.DBConnection;
import dragNdrop.DragListener;
import dragNdrop.DropListener;
import layouts.WrapLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SubjectsStudyGroupPanel extends JPanel
{
    private final Subject subject;
    private ArrayList<StudyGroup> studyGroups;

    public SubjectsStudyGroupPanel(Subject subject)
    {
        this.subject = subject;
        this.studyGroups = new ArrayList<>();
        this.initPanel();
    }

    private void initPanel()
    {
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 1, 0, Constants.secondaryColor),
                new EmptyBorder(5, 0, 5, 0)
        ));
        this.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 3));

        studyGroups = DBConnection.getInstance().getStudyGroupsForSubject(this.subject);

        for (StudyGroup studyGroup : studyGroups)
        {
            StudyGroupComponent workLabelComponent = new StudyGroupComponent(studyGroup);
            this.add(workLabelComponent);
            new DragListener(workLabelComponent, this);
        }
        new DropListener(this);
    }

    public Subject getSubject()
    {
        return this.subject;
    }
}
