package dragNdrop;

import Components.Panels.DashboardBodyPanel;
import Components.Panels.EmployeeWorkLabelsPanel;
import Components.Panels.SubjectsStudyGroupPanel;
import Components.Panels.WorkLabelsPanel;
import Components.StudyGroupComponent;
import Components.WorkLabelComponent;
import Services.DBConnection;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

public class DropListener extends DropTargetAdapter
{
    private final JComponent parentComponent;

    public DropListener(JComponent parentComponent)
    {
        this.parentComponent = parentComponent;
        new DropTarget(this.parentComponent, DnDConstants.ACTION_MOVE, this, true, null);
    }

    @Override
    public void drop(DropTargetDropEvent dtde)
    {
        try
        {
            JComponent component = (JComponent) dtde.getTransferable().getTransferData(new DataFlavor(JComponent.class,
                    "draggable component"));

            if (parentComponent instanceof SubjectsStudyGroupPanel)
            {
                this.addStudyGroupToSubject(component);
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                dtde.dropComplete(true);

                //todo - here must be recalculation from component and create new work labels

                return;
            } else if (parentComponent instanceof DashboardBodyPanel)
                this.removeEmployeeWorkLabel(component);

            else if (parentComponent instanceof EmployeeWorkLabelsPanel)
                this.addWorkLabelToEmployee(component);

            dtde.acceptDrop(DnDConstants.ACTION_MOVE);
            dtde.dropComplete(true);

        } catch (Exception e)
        {
            System.out.println(e.getClass());
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }

    private void removeEmployeeWorkLabel(JComponent component)
    {
        if (component instanceof WorkLabelComponent)
        {
            DBConnection.getInstance().updateEmployeeIdInWorkLabel(0, ((WorkLabelComponent) component).getWorkLabel().getId());
            WorkLabelsPanel workLabelsPanel = WorkLabelsPanel.getInstance();
            new DragListener(component, workLabelsPanel);
            workLabelsPanel.add(component);
            workLabelsPanel.revalidate();
            workLabelsPanel.repaint();
        }
    }

    private void addWorkLabelToEmployee(JComponent component)
    {
        DBConnection.getInstance().updateEmployeeIdInWorkLabel(((EmployeeWorkLabelsPanel) parentComponent).
                getEmployee().getId(), ((WorkLabelComponent) component).getWorkLabel().getId());
        parentComponent.add(component);
        ((EmployeeWorkLabelsPanel) parentComponent).getWorkLabels().add(((WorkLabelComponent) component).getWorkLabel());
        parentComponent.revalidate();
        parentComponent.repaint();
        new DragListener(component, parentComponent);
    }

    private void addStudyGroupToSubject(JComponent component)
    {
        boolean success = DBConnection.getInstance().addStudyGroupToSubject(((SubjectsStudyGroupPanel) parentComponent).getSubject(),
                ((StudyGroupComponent) component).getStudyGroup());
        if (success)
        {
            parentComponent.add(component);
            parentComponent.revalidate();
            parentComponent.repaint();
            new DragListener(component, parentComponent);
        }
    }
}
