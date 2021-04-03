package Common;

import Common.Enums.Language;
import Common.Enums.StudyForm;
import Common.Enums.StudyType;
import Common.Enums.Term;

import java.util.ArrayList;

public class StudyGroup
{
    private String abbreviation;
    private String name;
    private StudyType studyType;
    private StudyForm studyForm;
    private int year;
    private Term term;
    private int studentsCount = 36;
    private Language language;
    private ArrayList<Subject> subjects;
}
