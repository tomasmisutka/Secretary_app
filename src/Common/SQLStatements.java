package Common;

public interface SQLStatements
{
    String CONNECTION = "jdbc:mysql://localhost:3306/secretary";

    String TABLE_NAME_EMPLOYEES = "employees";
    String TABLE_NAME_STUDY_GROUPS = "study_groups";
    String TABLE_NAME_SUBJECTS = "subjects";
    String TABLE_NAME_WORK_LABELS = "work_labels";

    String SELECT_GLOBAL_CONFIGS = "SELECT * FROM global_configs";
    String NEW_EMPLOYEE = "INSERT INTO " + TABLE_NAME_EMPLOYEES +" (id, first_name, last_name, full_name, private_email, " +
            "job_email, work_points, work_points_en, is_doctoral, work_load, work_label_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String NEW_SUBJECT = "INSERT INTO " +  TABLE_NAME_SUBJECTS + " (id, abbreviation, weeks_count, lectures_count, " +
            "practises_count, seminars_count, classification, teach_language, class_size, study_group_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String NEW_STUDY_GROUP = "INSERT INTO " + TABLE_NAME_STUDY_GROUPS + " (abbreviation, study_year, term, students_count, " +
            "study_form, study_type, study_language) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String NEW_WORK_LABEL = "INSERT INTO " + TABLE_NAME_WORK_LABELS + " (name, employee_id, subject_id, event_type, students_count," +
            " hours_count, weeks_count, language_used, total_points) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String COMPARE_EMPLOYEE_NAME = "SELECT full_name FROM " + TABLE_NAME_EMPLOYEES + " WHERE full_name = ?";
    String GET_EMPLOYEES = "SELECT * FROM " + TABLE_NAME_EMPLOYEES;
    String GET_UNASSIGNED_WORK_LABELS = "SELECT * FROM " + TABLE_NAME_WORK_LABELS + " WHERE employee_id = 0";
    String GET_EMPLOYEE_BY_ID = "SELECT * FROM " + TABLE_NAME_EMPLOYEES + " WHERE id = ?";
    String GET_SUBJECT_BY_ID = "SELECT * FROM " + TABLE_NAME_SUBJECTS + " WHERE id = ?";
    String REMOVE_EMPLOYEE_BY_ID = "DELETE FROM " + TABLE_NAME_EMPLOYEES + " WHERE id = ?";
    String UPDATE_EMPLOYEE_ID_IN_WORK_LABEL = "UPDATE " + TABLE_NAME_WORK_LABELS + " SET employee_id = ? WHERE id = ?";
    String GET_WORK_LABELS_ASSIGNED_TO_EMPLOYEE = "SELECT * FROM " + TABLE_NAME_WORK_LABELS + " WHERE employee_id = ?";
    String GET_AVAILABLE_ID = "SELECT MIN( id + 1 ) FROM $table_name WHERE id + 1 NOT IN (SELECT id FROM $table_name)";
    String UPDATE_EMPLOYEE_BY_ID = "UPDATE " + TABLE_NAME_EMPLOYEES + " SET first_name = ?, last_name = ?, full_name = ?, " +
            "private_email = ?, job_email = ?, work_points = ?, work_points_en = ?, is_doctoral = ?, work_load = ? WHERE id = ?";
    String GET_SUBJECTS = "SELECT * FROM " + TABLE_NAME_SUBJECTS + " WHERE study_group_id = 0";
    String DELETE_SUBJECT_BY_ID = "DELETE FROM " + TABLE_NAME_SUBJECTS + " WHERE id = ?";
    String GET_STUDY_GROUPS = "SELECT * FROM " + TABLE_NAME_STUDY_GROUPS;
    String GET_STUDY_GROUPS_FOR_SUBJECT = "SELECT * FROM " + TABLE_NAME_SUBJECTS + " WHERE id = ? AND study_group_id != 0";
    // todo below must be updated
}
