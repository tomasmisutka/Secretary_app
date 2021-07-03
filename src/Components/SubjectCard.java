package Components;

import Common.Subject;
import Components.Panels.SubjectPanel;
import Components.Panels.SubjectsStudyGroupPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectCard extends JPanel implements ActionListener
{
    private final Subject subject;
    private final SubjectsStudyGroupPanel studyGroupsPanel;
    private final JButton deleteButton;

    public SubjectCard(Subject subject)
    {
        this.subject = subject;
        this.studyGroupsPanel = new SubjectsStudyGroupPanel(this.subject);
        this.deleteButton = new JButton("delete");
        this.deleteButton.addActionListener(this);
        this.initCard();
    }

    public Subject getSubject()
    {
        return this.subject;
    }

    private void initCard()
    {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(165, 175));

        JScrollPane scrollPane = new JScrollPane(studyGroupsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.add(this.getTitlePanel(), BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(deleteButton, BorderLayout.SOUTH);
    }

    private JPanel getTitlePanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());

        JLabel title = new JLabel();
        title.setText(this.subject.getAbbreviation().toUpperCase());
        title.setIcon(new ImageIcon("./src/Images/button_subject.png"));
        title.setHorizontalTextPosition(SwingConstants.RIGHT);

        panel.add(title, new GridBagConstraints());
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.deleteButton)
        {
            int result = MessageDialog.showConfirmationDialog(null, "Do you want to delete subject " +
                    this.subject.getAbbreviation() + " ?");
            if (result == JOptionPane.YES_OPTION)
                SubjectPanel.getInstance().removeSubject(this);

        }
    }
}
