package Components;

import Common.WorkLabel;
import Components.Panels.CommonRoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

public class WorkLabelComponent extends CommonRoundedPanel implements DragGestureListener
{
    private final WorkLabel workLabel;

    public WorkLabelComponent(Color background, int radius, WorkLabel workLabel)
    {
        super(background, radius);
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

        //draggable implementation below
        DragSource dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dragGestureEvent)
    {
        Cursor cursor = Cursor.getDefaultCursor();
        if (dragGestureEvent.getDragAction() == DnDConstants.ACTION_MOVE)
            cursor = DragSource.DefaultMoveDrop;
        dragGestureEvent.startDrag(cursor, new TransferableWorkLabel(workLabel));
    }

    public WorkLabel getWorkLabel()
    {
        return workLabel;
    }
}
