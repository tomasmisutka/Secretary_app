package Common;

public interface SqlStatements {
    String CONNECTION = "jdbc:mysql://localhost:3306/secretary";
    String GLOBAL_CONFIGS_DB = "SELECT * FROM global_configs";
    String NEW_EMPLOYEE_STATEMENT = "INSERT INTO Employees (FirstName, LastName, FullName, PrivateEmail, JobEmail, WorkPoints, " +
            "WorkPointsEN, IsDoctoral, WorkLoad, WorkLabelID)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String NEW_SUBJECT_STATEMENT = "INSERT INTO Subjects (Abbreviation, WeeksCount, LecturesCount, PractisesCount, SeminarsCount, Classification, " +
            "TeachLanguage, ClassSize, StudyGroupID)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
