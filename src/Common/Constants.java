package Common;

import java.awt.*;

public interface Constants
{
    Color primaryColor = new Color(255,215,0);
    Color secondaryColor = new Color(70, 72, 74);

    //DB account credentials
    String dbLoginName = "student";
    String dbLoginPassword = "student";

    //components texts
    String yesButtonText = "YES";
    String noButtonText = "NO";
    String winterRadioButtonText = "WINTER";
    String summerRadioButtonText = "SUMMER";
    String presentFormButtonText = "PRESENT";
    String combinedFormButtonText = "COMBINED";
    String bachelorsTypeButtonText = "BACHELORS";
    String mastersTypeButtonText = "MASTERS";
    String czLanguageText = "CZ";
    String enLanguageText = "EN";

    //DB constants
    int ERROR_OCCURS = 0;
    int EMPLOYEE_EXISTS = 1;
    int NAME_AVAILABLE = 2;
}
