package Components.AddForms;

import Common.Constants;
import Common.Enums.EventType;
import Common.Enums.FormPanelType;
import Common.Enums.Language;
import Common.WorkLabel;
import Components.Panels.AddFormButtonsPanel;
import Components.Panels.FormTitlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddWorkLabelForm extends JFrame
{
    private static final JTextField nameTextField = new JTextField("Practise AK8PO");
    private static final JComboBox<EventType> eventTypeComboBox = new JComboBox<>(EventType.values());
    private static final JTextField studentsCountTextField = new JTextField("11");
    private static final ButtonGroup languageGroup = new ButtonGroup();

    public AddWorkLabelForm()
    {
        this.createPanel();
    }

    private void createPanel()
    {
        this.setLayout(new GridBagLayout());
        FormTitlePanel titlePanel = new FormTitlePanel("Add new subject");
        JPanel dataPanel = new JPanel();
        AddFormButtonsPanel buttonsPanel = new AddFormButtonsPanel(FormPanelType.Subject, this);

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

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(contentFont);
        JLabel eventTypeLabel = new JLabel("Event type:");
        eventTypeLabel.setFont(contentFont);
        JLabel studentsCountLabel = new JLabel("Number of students:");
        studentsCountLabel.setFont(contentFont);
        JLabel languageLabel = new JLabel("Language");
        languageLabel.setFont(contentFont);

        JRadioButton czLanguage = new JRadioButton(Constants.czLanguageText);
        czLanguage.setActionCommand(Constants.czLanguageText);
        czLanguage.setFont(contentFont);
        JRadioButton enLanguage = new JRadioButton(Constants.enLanguageText);
        enLanguage.setActionCommand(Constants.enLanguageText);
        enLanguage.setFont(contentFont);
        languageGroup.add(czLanguage);
        languageGroup.add(enLanguage);
        languageGroup.setSelected(czLanguage.getModel(), true);

        dataPanel.add(nameLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(nameTextField, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(eventTypeLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(eventTypeComboBox, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(studentsCountLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(studentsCountTextField, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0, 0));
        dataPanel.add(languageLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(czLanguage, new GridBagConstraints(1, 3, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        dataPanel.add(enLanguage, new GridBagConstraints(2, 3, 1, 1, 0.2, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
    }

    public static WorkLabel getNewWorkLabel()
    {
        WorkLabel newWorkLabel = new WorkLabel();

        Integer selectedStudents = new Integer(studentsCountTextField.getText());
        Language selectedLanguage = Language.CZ;
        if (languageGroup.getSelection().getActionCommand().equals("EN"))
            selectedLanguage = Language.EN;

        newWorkLabel.setName(nameTextField.getName());
        newWorkLabel.setEmployee(null);
        newWorkLabel.setSubject(null);
        newWorkLabel.setEventType(getSelectedEvent());
        newWorkLabel.setStudentsCount(selectedStudents);
//        newWorkLabel.setHoursCount();
//        newWorkLabel.setWeeksCount();
        newWorkLabel.setLanguage(selectedLanguage);
//        newWorkLabel.setTotalPoints();

        return null;
    }

    private static EventType getSelectedEvent()
    {
        return (EventType) eventTypeComboBox.getSelectedItem();
    }


}
