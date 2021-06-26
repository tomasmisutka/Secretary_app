package Components;

import Common.Constants;
import Common.Employee;
import Common.WorkLabel;
import Components.Panels.WorkLabelsPanel;

import javax.swing.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

public class WorkLabelsDropTarget extends DropTargetAdapter
{
    private final JPanel dropPanel;
    private final Employee employee;

    public WorkLabelsDropTarget(JPanel dropPanel, Employee employee)
    {
        this.dropPanel = dropPanel;
        this.employee = employee;
        DropTarget dropTarget = new DropTarget(this.dropPanel, DnDConstants.ACTION_MOVE,
                this, true, null);
    }

    @Override
    public void drop(DropTargetDropEvent dropTargetDropEvent)
    {
        try
        {
            Transferable transferable = dropTargetDropEvent.getTransferable();
            WorkLabel transferredWorkLabel = (WorkLabel) transferable.getTransferData(TransferableWorkLabel.workLabelFlavor);

            if (dropTargetDropEvent.isDataFlavorSupported(TransferableWorkLabel.workLabelFlavor))
            {
                WorkLabelComponent workLabelComponent = new WorkLabelComponent(Constants.secondaryColor, 15, transferredWorkLabel);
                dropTargetDropEvent.acceptDrop(DnDConstants.ACTION_MOVE);
                dropPanel.add(workLabelComponent);
                dropTargetDropEvent.dropComplete(true);

                WorkLabelsPanel.getInstance().assignWorkLabelToEmployee(workLabelComponent, employee);
                //todo - here should be method to recalculate employees work points
                dropPanel.revalidate();
                return;
            }

            dropTargetDropEvent.rejectDrop();
        } catch (Exception e)
        {
            e.printStackTrace();
            dropTargetDropEvent.rejectDrop();
        }
    }
}
