package Components.Panels;

import Common.StudyGroup;
import Components.AddForms.AddStudyGroupForm;
import Components.StudyGroupComponent;
import Services.DBConnection;
import dragNdrop.DragListener;
import layouts.VerticalFlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class StudyGroupsPanel extends JPanel
{
    private final static StudyGroupsPanel studyGroupsPanel = new StudyGroupsPanel();
    private ArrayList<StudyGroup> studyGroups = new ArrayList<>();

    private StudyGroupsPanel()
    {
        this.createPanel();
    }

    public static StudyGroupsPanel getInstance()
    {
        return studyGroupsPanel;
    }

    private void createPanel()
    {
        this.setBorder(new EmptyBorder(0, 5, 0, 5));
        this.setBackground(Color.white);
        this.setLayout(new VerticalFlowLayout());
        this.initContent();
    }

    private void initContent()
    {
        studyGroups = DBConnection.getInstance().getStudyGroups();

        for (StudyGroup studyGroup : studyGroups)
        {
            StudyGroupComponent studyGroupComponent = new StudyGroupComponent(studyGroup);
            new DragListener(studyGroupComponent, this);
            this.add(studyGroupComponent);
        }
    }

    public boolean addStudyGroupToPanel(StudyGroup studyGroup)
    {
        boolean success = DBConnection.getInstance().sendStudyGroupToDB(AddStudyGroupForm.getNewStudyGroup());
        if (success)
        {
            StudyGroupComponent studyGroupComponent = new StudyGroupComponent(studyGroup);
            studyGroups.add(studyGroup);
            this.add(studyGroupComponent);
            this.revalidate();
            new DragListener(studyGroupComponent, this);
        }
        return success;
    }
}

