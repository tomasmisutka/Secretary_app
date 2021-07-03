package Components.Panels;

import Common.Subject;
import Components.SubjectCard;
import Services.DBConnection;
import layouts.WrapLayout;

import javax.swing.*;
import java.util.ArrayList;

public class SubjectPanel extends JPanel
{
    private final static SubjectPanel subjectPanel = new SubjectPanel();
    private ArrayList<Subject> subjects = new ArrayList<>();

    private SubjectPanel()
    {
        this.setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
        this.prepareContent();
    }

    public static SubjectPanel getInstance()
    {
        return subjectPanel;
    }

    private void prepareContent()
    {
        subjects = DBConnection.getInstance().getSubjects();

        for (Subject subject : subjects)
            this.add(new SubjectCard(subject));
    }

    public boolean addNewSubject(Subject subject)
    {
        boolean success = DBConnection.getInstance().sendSubjectToDB(subject, 0);
        if (success)
        {
            subjects.add(subject);
            this.add(new SubjectCard(subject));
            this.revalidate();
        }
        return success;
    }

    public void removeSubject(SubjectCard subjectCard)
    {
        boolean success = DBConnection.getInstance().removeSubject(subjectCard.getSubject());
        if (success)
        {
            subjects.remove(subjectCard.getSubject());
            this.remove(subjectCard);
            this.revalidate();
            this.repaint();
        }
    }
}
