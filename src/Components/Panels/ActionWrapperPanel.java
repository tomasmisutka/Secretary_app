package Components.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ActionWrapperPanel extends JPanel
{
    private final JComponent workLabelPanel;
    private final JComponent studyGroupPanel;
    private static int activePanel;
    private boolean visibility;

    public ActionWrapperPanel(JComponent workLabelPanel, JComponent studyGroupPanel)
    {
        this.workLabelPanel = workLabelPanel; // 1 - active work label panel
        this.studyGroupPanel = studyGroupPanel; // 2 - active study group panel
        activePanel = 1;
        this.visibility = true;
        this.createContent();
    }

    private void createContent()
    {
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(0,0,0,0));
        this.add(workLabelPanel);
        this.add(studyGroupPanel);
        this.changeContent();
    }

    private void changeContent()
    {
        if (activePanel == 1)
        {
            this.remove(studyGroupPanel);
            this.add(workLabelPanel);
        } else
        {
            this.remove(workLabelPanel);
            this.add(studyGroupPanel);
        }
        this.revalidate();
    }

    public void changeContent(int activationPanel)
    {
        activePanel = activationPanel;
        this.changeContent();
    }

    public void changeVisibility()
    {
        this.visibility = !this.visibility;
        this.setVisible(visibility);
        this.revalidate();
    }

}
