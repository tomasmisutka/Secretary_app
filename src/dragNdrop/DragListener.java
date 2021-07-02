package dragNdrop;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.io.IOException;

public class DragListener implements DragGestureListener, Transferable
{
    private final JComponent component;
    private final JComponent parentComponent;

    public DragListener(JComponent component, JComponent parentComponent)
    {
        this.component = component;
        this.parentComponent = parentComponent;
        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(this.component,
                DnDConstants.ACTION_MOVE, this);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors()
    {
        return new DataFlavor[]{
                new DataFlavor(JComponent.class, "draggable component")
        };
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
    {
        parentComponent.remove(component);
        parentComponent.revalidate();
        parentComponent.repaint();
        return (JComponent) this.component;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) { dge.startDrag(DragSource.DefaultCopyDrop, this); }
}
