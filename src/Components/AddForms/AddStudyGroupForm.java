package Components.AddForms;

import Common.Constants;
import Common.Enums.FormPanelType;
import Common.Enums.Language;
import Common.Enums.StudyForm;
import Common.Enums.StudyType;
import Common.Enums.Term;
import Common.StudyGroup;
import Components.Panels.FormConfirmationsPanel;
import Components.Panels.FormTitlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddStudyGroupForm extends JFrame
{
    private static int instanceCounter = 0;
    private static final JTextField abbreviationTextField = new JTextField("KYB");
    private static final Integer[] yearComboBoxValues = {1, 2, 3, 4, 5};
    private static final JComboBox<Integer> yearComboBox = new JComboBox<>(yearComboBoxValues);
    private static final ButtonGroup termGroup = new ButtonGroup();
    private static final JTextField studentsCounterTextField = new JTextField("36");
    private static final ButtonGroup studyFormGroup = new ButtonGroup();
    private static final ButtonGroup studyTypeGroup = new ButtonGroup();
    private static final ButtonGroup languageGroup = new ButtonGroup();

    public AddStudyGroupForm()
    {
        this.createContent();
    }

    public static int getInstanceCounter()
    {
        return instanceCounter;
    }

    public static void releaseInstance()
    {
        instanceCounter = 0;
    }

    private void createContent()
    {
        instanceCounter++;
        this.setLayout(new GridBagLayout());
        FormTitlePanel titlePanel = new FormTitlePanel("Add new study group");
        JPanel dataPanel = new JPanel();
        FormConfirmationsPanel buttonsPanel = new FormConfirmationsPanel(FormPanelType.Study_Group, this, false); // todo - edit later maybe

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

        JRadioButton termWinter = new JRadioButton(Constants.winterRadioButtonText);
        termWinter.setFont(contentFont);
        termWinter.setActionCommand(Constants.winterRadioButtonText);
        JRadioButton termSummer = new JRadioButton(Constants.summerRadioButtonText);
        termSummer.setFont(contentFont);
        termSummer.setActionCommand(Constants.summerRadioButtonText);
        termGroup.add(termWinter);
        termGroup.add(termSummer);
        termGroup.setSelected(termWinter.getModel(), true);

        JRadioButton studyFormPresent = new JRadioButton(Constants.presentFormButtonText);
        studyFormPresent.setFont(contentFont);
        studyFormPresent.setActionCommand(Constants.presentFormButtonText);
        JRadioButton studyFormCombined = new JRadioButton(Constants.combinedFormButtonText);
        studyFormCombined.setFont(contentFont);
        studyFormCombined.setActionCommand(Constants.combinedFormButtonText);
        studyFormGroup.add(studyFormPresent);
        studyFormGroup.add(studyFormCombined);
        studyFormGroup.setSelected(studyFormPresent.getModel(), true);

        JRadioButton studyTypeBachelors = new JRadioButton(Constants.bachelorsTypeButtonText);
        studyTypeBachelors.setFont(contentFont);
        studyTypeBachelors.setActionCommand(Constants.bachelorsTypeButtonText);
        JRadioButton studyTypeMasters = new JRadioButton(Constants.mastersTypeButtonText);
        studyTypeMasters.setFont(contentFont);
        studyTypeMasters.setActionCommand(Constants.mastersTypeButtonText);
        studyTypeGroup.add(studyTypeBachelors);
        studyTypeGroup.add(studyTypeMasters);
        studyTypeGroup.setSelected(studyTypeBachelors.getModel(), true);

        JRadioButton languageCZ = new JRadioButton(Constants.czLanguageText);
        languageCZ.setFont(contentFont);
        languageCZ.setActionCommand(Constants.czLanguageText);
        JRadioButton languageEN = new JRadioButton(Constants.enLanguageText);
        languageEN.setFont(contentFont);
        languageEN.setActionCommand(Constants.enLanguageText);
        languageGroup.add(languageCZ);
        languageGroup.add(languageEN);
        languageGroup.setSelected(languageCZ.getModel(), true);

        dataPanel.add(abbreviationLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(abbreviationTextField, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(yearLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(yearComboBox, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(termLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(termWinter, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(termSummer, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(studentsCountLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(studentsCounterTextField, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(studyFormLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(studyFormPresent, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(studyFormCombined, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(studyTypeLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(studyTypeBachelors, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(studyTypeMasters, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(languageLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(languageCZ, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
        dataPanel.add(languageEN, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));

    }

    public static StudyGroup getNewStudyGroup()
    {
        StudyGroup newStudyGroup = new StudyGroup();

        Integer studyYear = (Integer) yearComboBox.getSelectedItem();
        Term selectedTerm = Term.WINTER;
        if (termGroup.getSelection().getActionCommand().equals("SUMMER"))
            selectedTerm = Term.SUMMER;
        Integer studentsCounter = new Integer(studentsCounterTextField.getText());
        StudyForm selectedStudyForm = StudyForm.PRESENT;
        if (studyFormGroup.getSelection().getActionCommand().equals("COMBINED"))
            selectedStudyForm = StudyForm.COMBINED;
        StudyType selectedStudyType = StudyType.BACHELORS;
        if (studyTypeGroup.getSelection().getActionCommand().equals("MASTERS"))
            selectedStudyType = StudyType.MASTERS;
        Language selectedLanguage = Language.CZ;
        if (languageGroup.getSelection().getActionCommand().equals("EN"))
            selectedLanguage = Language.EN;

        newStudyGroup.setAbbreviation(abbreviationTextField.getText());
        newStudyGroup.setYear(studyYear == null ? 2021 : studyYear);
        newStudyGroup.setTerm(selectedTerm);
        newStudyGroup.setStudentsCount(studentsCounter);
        newStudyGroup.setStudyForm(selectedStudyForm);
        newStudyGroup.setStudyType(selectedStudyType);
        newStudyGroup.setLanguage(selectedLanguage);

        return newStudyGroup;
    }
}
