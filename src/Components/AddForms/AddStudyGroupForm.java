package Components.AddForms;

import Common.Enums.FormPanelType;
import Common.StudyGroup;
import Components.Panels.AddFormButtonsPanel;
import Components.Panels.FormTitlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddStudyGroupForm extends JFrame
{
    private static AddStudyGroupForm studyGroupForm = null;
    private final JTextField abbreviationTextField = new JTextField("KYB");
    private final Integer[] yearComboBoxValues = {1,2,3,4,5};
    private final JComboBox<Integer> yearComboBox = new JComboBox<>(yearComboBoxValues);
    private final ButtonGroup termGroup = new ButtonGroup();
    private final JTextField studentsCounterTextField = new JTextField("36");
    private final ButtonGroup studyFormGroup = new ButtonGroup();
    private final ButtonGroup studyTypeGroup = new ButtonGroup();
    private final ButtonGroup languageGroup = new ButtonGroup();

    private AddStudyGroupForm()
    {
        super();
        this.createContent();
    }

    public static AddStudyGroupForm getInstance()
    {
        if (studyGroupForm == null)
            studyGroupForm = new AddStudyGroupForm();
        return studyGroupForm;
    }

    public static void setStudyGroupFormAsNull()
    {
        studyGroupForm = null;
    }

    private void createContent()
    {
        this.setLayout(new GridBagLayout());
        FormTitlePanel titlePanel = new FormTitlePanel("Add new study group");
        JPanel dataPanel = new JPanel();
        AddFormButtonsPanel buttonsPanel = new AddFormButtonsPanel(FormPanelType.Study_Group);

        this.initDataPanel(dataPanel);

        this.add(titlePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(dataPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setFont(contentFont);
        JLabel termLabel = new JLabel("Term:");
        termLabel.setFont(contentFont);
        JLabel studentsCountLabel = new JLabel("Number of students:");
        studentsCountLabel.setFont(contentFont);
        JLabel studyFormLabel = new JLabel("Study form:");
        studyFormLabel.setFont(contentFont);
        JLabel studyTypeLabel = new JLabel("Study type:");
        studyTypeLabel.setFont(contentFont);
        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setFont(contentFont);

        JRadioButton termWinter = new JRadioButton("WINTER");
        termWinter.setFont(contentFont);
        termWinter.setActionCommand("WINTER");
        termWinter.setSelected(true);
        JRadioButton termSummer = new JRadioButton("SUMMER");
        termSummer.setFont(contentFont);
        termSummer.setActionCommand("SUMMER");
        this.termGroup.add(termWinter);
        this.termGroup.add(termSummer);

        JRadioButton studyFormPresent = new JRadioButton("PRESENT");
        studyFormPresent.setFont(contentFont);
        studyFormPresent.setActionCommand("PRESENT");
        studyFormPresent.setSelected(true);
        JRadioButton studyFormCombined = new JRadioButton("COMBINED");
        studyFormCombined.setFont(contentFont);
        studyFormCombined.setActionCommand("COMBINED");
        this.studyFormGroup.add(studyFormPresent);
        this.studyFormGroup.add(studyFormCombined);

        JRadioButton studyTypeBachelors = new JRadioButton("BACHELORS");
        studyTypeBachelors.setFont(contentFont);
        studyTypeBachelors.setActionCommand("BACHELORS");
        studyTypeBachelors.setSelected(true);
        JRadioButton studyTypeMasters = new JRadioButton("MASTERS");
        studyTypeMasters.setFont(contentFont);
        studyTypeMasters.setActionCommand("MASTERS");
        this.studyTypeGroup.add(studyTypeBachelors);
        this.studyTypeGroup.add(studyTypeMasters);

        JRadioButton languageCZ = new JRadioButton("CZ");
        languageCZ.setFont(contentFont);
        languageCZ.setActionCommand("CZ");
        languageCZ.setSelected(true);
        JRadioButton languageEN = new JRadioButton("EN");
        languageEN.setFont(contentFont);
        languageEN.setActionCommand("EN");
        this.languageGroup.add(languageCZ);
        this.languageGroup.add(languageEN);

        dataPanel.add(abbreviationLabel, new GridBagConstraints(0,0,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(this.abbreviationTextField, new GridBagConstraints(1,0,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,0),0,0));
        dataPanel.add(yearLabel, new GridBagConstraints(0,1,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(this.yearComboBox, new GridBagConstraints(1,1,2,1,1.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,0),0,0));
        dataPanel.add(termLabel, new GridBagConstraints(0,2,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(termWinter, new GridBagConstraints(1,2,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(termSummer, new GridBagConstraints(2,2,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(studentsCountLabel, new GridBagConstraints(0,3,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(this.studentsCounterTextField, new GridBagConstraints(1,3,2,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,5,5,0),0,0));
        dataPanel.add(studyFormLabel, new GridBagConstraints(0,4,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(studyFormPresent, new GridBagConstraints(1,4,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(studyFormCombined, new GridBagConstraints(2,4,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(studyTypeLabel, new GridBagConstraints(0,5,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(studyTypeBachelors, new GridBagConstraints(1,5,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(studyTypeMasters, new GridBagConstraints(2,5,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(languageLabel, new GridBagConstraints(0,6,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,0,5,0),0,0));
        dataPanel.add(languageCZ, new GridBagConstraints(1,6,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));
        dataPanel.add(languageEN, new GridBagConstraints(2,6,1,1,0.0,0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,5,5,0),0,0));

    }

    public StudyGroup getNewStudyGroup()
    {
        return null;
    }
}
