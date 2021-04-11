package Components.AddForms;

import Common.Enums.Classification;
import Common.Enums.FormPanelType;
import Common.Enums.Language;
import Common.Subject;
import Components.Panels.AddFormButtonsPanel;
import Components.Panels.FormTitlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddSubjectForm extends JFrame
{
    private static AddSubjectForm subjectForm = null;
    private final JTextField abbreviationTextField = new JTextField("AK8PO");
    private final JTextField weeksCountTextField = new JTextField("14");
    private final JTextField lecturesTextField = new JTextField("1");
    private final JTextField practiseTextField = new JTextField("3");
    private final JTextField seminarTextField = new JTextField("2");
    private final JComboBox<Classification> classificationComboBox = new JComboBox<>(Classification.values());
    private final ButtonGroup languageGroup = new ButtonGroup();
    private final Integer[] groupSizeComboBoxValues = {24, 12, 0};
    private final JComboBox<Integer> groupSizeComboBox = new JComboBox<>(groupSizeComboBoxValues);

    private AddSubjectForm()
    {
        this.createContent();
    }

    public static AddSubjectForm getInstance()
    {
        if (subjectForm == null)
            subjectForm = new AddSubjectForm();
        return subjectForm;
    }

    public static void setSubjectFormAsNull()
    {
        subjectForm = null;
    }

    private void createContent()
    {
        this.setLayout(new GridBagLayout());
        FormTitlePanel titlePanel = new FormTitlePanel("Add new subject");
        JPanel dataPanel = new JPanel();
        AddFormButtonsPanel buttonsPanel = new AddFormButtonsPanel(FormPanelType.Subject);

        this.initDataPanel(dataPanel);

        this.add(titlePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(dataPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        this.add(buttonsPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        this.setSize(new Dimension(400, 450));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initDataPanel(JPanel dataPanel)
    {
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
        Font contentFont = new Font("Arial", Font.ITALIC, 15);

        JLabel abbreviationLabel = new JLabel("Abbreviation:");
        abbreviationLabel.setFont(contentFont);
        JLabel weekCountLabel = new JLabel("Weeks:");
        weekCountLabel.setFont(contentFont);
        JLabel lectureLabel = new JLabel("Lectures:");
        lectureLabel.setFont(contentFont);
        JLabel practiseLabel = new JLabel("Practises:");
        practiseLabel.setFont(contentFont);
        JLabel seminarLabel = new JLabel("Seminars:");
        seminarLabel.setFont(contentFont);
        JLabel classificationLabel = new JLabel("Classification:");
        classificationLabel.setFont(contentFont);
        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setFont(contentFont);
        JLabel groupSizeLabel = new JLabel("Group size:");
        groupSizeLabel.setFont(contentFont);

        JRadioButton czLanguage = new JRadioButton("CZ");
        czLanguage.setActionCommand("CZ");
        czLanguage.setSelected(true);
        czLanguage.setFont(contentFont);
        JRadioButton enLanguage = new JRadioButton("EN");
        enLanguage.setActionCommand("EN");
        enLanguage.setFont(contentFont);
        this.languageGroup.add(czLanguage);
        this.languageGroup.add(enLanguage);

        dataPanel.add(abbreviationLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.abbreviationTextField, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(weekCountLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.weeksCountTextField, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(lectureLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.lecturesTextField, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(practiseLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.practiseTextField, new GridBagConstraints(1, 3, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(seminarLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.seminarTextField, new GridBagConstraints(1, 4, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(classificationLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.classificationComboBox, new GridBagConstraints(1, 5, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(languageLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(czLanguage, new GridBagConstraints(1, 6, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(enLanguage, new GridBagConstraints(2, 6, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(groupSizeLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(this.groupSizeComboBox, new GridBagConstraints(1, 7, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));

    }

    public Subject getNewSubject()
    {
        Subject subject = new Subject();
        subject.setAbbreviation(this.abbreviationTextField.getText());
        subject.setWeeksCount(new Integer(this.weeksCountTextField.getText()));
        subject.setLecturesCount(new Integer(this.lecturesTextField.getText()));
        subject.setPracticesCount(new Integer(this.practiseTextField.getText()));
        subject.setSeminarsCount(new Integer(this.seminarTextField.getText()));
        Classification selectedClassification = (Classification) this.classificationComboBox.getSelectedItem();
        subject.setClassification(selectedClassification);
        Language selectedLanguage = Language.CZ;
        if (this.languageGroup.getSelection().getActionCommand().equals("EN"))
            selectedLanguage = Language.EN;
        subject.setLanguage(selectedLanguage);
        Integer selectedGroupSize = (Integer) this.groupSizeComboBox.getSelectedItem();
        subject.setDefaultGroupSize(selectedGroupSize);
        return subject;
    }
}
