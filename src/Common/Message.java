package Common;

public interface Message
{
    String EXIT_APP = "Are you sure? You will exit this app...";
    String DB_CONNECTION_ERROR = "DATABASE connection PROBLEM!!!";
    String DB_EMPLOYEE_ERROR = "CAN NOT INSERT THE EMPLOYEE TO DATABASE";
    String DB_SUBJECT_ERROR = "CAN NOT INSERT THE SUBJECT TO DATABASE";
    String DB_STUDY_GROUP_ERROR = "CAN NOT INSERT THE STUDY GROUP TO DATABASE";
    String DB_WORK_LABEL_ERROR = "CAN NOT INSERT THE WORK LABEL TO DATABASE";
    String DB_EMPLOYEE_NAME_CHECK_ERROR = "ERROR WHILE CHECKING NAME IN DATABASE";
    String CONFIRM_REMOVE_EMPLOYEE = "Are you sure, that you want to delete employee ";
    String WORK_LABEL_NOT_ASSIGNED = "Work label was not assigned to employee";
}
