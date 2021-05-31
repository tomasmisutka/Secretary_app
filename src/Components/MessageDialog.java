package Components;

import javax.swing.*;
import java.awt.*;

public class MessageDialog
{
    public static int showConfirmationDialog(Component parentComponent, String message)
    {
        return JOptionPane.showConfirmDialog(parentComponent, message, "Confirmation",
                JOptionPane.YES_NO_OPTION);
    }

    public static void showErrorDialog(Component parentComponent, String message)
    {
        JOptionPane.showMessageDialog(parentComponent,message,"Failure",JOptionPane.ERROR_MESSAGE);
    }

}
