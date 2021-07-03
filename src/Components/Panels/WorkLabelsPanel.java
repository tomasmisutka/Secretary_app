package Components.Panels;

import Common.WorkLabel;
import Components.WorkLabelComponent;
import Services.DBConnection;
import dragNdrop.DragListener;
import layouts.VerticalFlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class WorkLabelsPanel extends JPanel

{
    private final static WorkLabelsPanel labelsPanel = new WorkLabelsPanel();
    private ArrayList<WorkLabel> workLabels = new ArrayList<>();

    private WorkLabelsPanel()
    {
        this.createPanel();
    }

    public static WorkLabelsPanel getInstance()
    {
        return labelsPanel;
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
        workLabels = DBConnection.getInstance().getUnassignedWorkLabels();

        for (WorkLabel workLabel : workLabels)
        {
            WorkLabelComponent workLabelComponent = new WorkLabelComponent(workLabel);
            new DragListener(workLabelComponent, this);
            this.add(workLabelComponent);
        }
    }

    public ArrayList<WorkLabel> getWorkLabels()
    {
        return this.workLabels;
    }
}
