package Components;

import Common.WorkLabel;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class TransferableWorkLabel implements Transferable
{
    private final WorkLabel workLabel;

    public TransferableWorkLabel(WorkLabel workLabel)
    {
        this.workLabel = workLabel;
    }

    protected static final DataFlavor workLabelFlavor =
            new DataFlavor(WorkLabel.class, "A WorkLabel Object");

    protected static final DataFlavor[] supportedFlavors = {workLabelFlavor};

    @Override
    public DataFlavor[] getTransferDataFlavors()
    {
        return supportedFlavors;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
    {
        if (flavor.equals(workLabelFlavor))
        {
            return workLabel;
        } else
        {
            System.out.println("*** getTransferData() error in TransferableWorkLabel class ***");
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.equals(workLabelFlavor);
    }
}
