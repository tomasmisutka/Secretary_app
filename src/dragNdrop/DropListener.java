package dragNdrop;

import Components.Panels.DashboardBodyPanel;
import Components.Panels.EmployeeWorkLabelsPanel;
import Components.Panels.WorkLabelsPanel;
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
            if (parentComponent instanceof DashboardBodyPanel)
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
            } else
            {
                if (parentComponent instanceof EmployeeWorkLabelsPanel)
                {
                    DBConnection.getInstance().updateEmployeeIdInWorkLabel(((EmployeeWorkLabelsPanel) parentComponent).
                            getEmployee().getId(), ((WorkLabelComponent) component).getWorkLabel().getId());
                    parentComponent.add(component);
                    parentComponent.revalidate();
                    parentComponent.repaint();
                    new DragListener(component, parentComponent);
                }
            }
            dtde.acceptDrop(DnDConstants.ACTION_MOVE);
            dtde.dropComplete(true);

        } catch (Exception e)
        {
            System.out.println(e.getClass());
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
