package Components.Panels;

import Common.WorkLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class StudyGroupsPanel extends JPanel
{
    private final static StudyGroupsPanel studyGroupsPanel = new StudyGroupsPanel();
    private ArrayList<WorkLabel> studyGroups = new ArrayList<>();

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
        JLabel test = new JLabel("TEST ONLY");
        this.setBorder(new EmptyBorder(0, 10, 0, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(test);
        this.initContent();
    }

    private void initContent()
    {
//        studyGroups = DBConnection.getInstance().getUnassignedWorkLabels(); //todo will be changed to getUnassignedStudyGroups();

//        for (WorkLabel workLabel : studyGroups)
//        {
//            WorkLabelComponent workLabelComponent = new WorkLabelComponent(workLabel);
//            this.add(workLabelComponent);
//        } //todo - here will be created a new StudyGroupComponent
    }

    //todo - also here will be method to add new studyGroup to panel
//    public void addStudyGroupToPanel(StudyGroupComponent studyGroupComponent)
//    {
//        boolean success = DBConnection.getInstance().updateEmployeeIdInWorkLabel(0, workLabelComponent.getWorkLabel().getId());
//        if (success)
//        {
//            studyGroups.add(workLabelComponent.getWorkLabel());
//            this.add(workLabelComponent);
//            this.revalidate();
//        }
//    }
}

