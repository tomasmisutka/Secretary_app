package Common;

import Common.Enums.Classification;
import Common.Enums.Language;
import Common.Enums.StudyForm;
import Common.Enums.Term;

import java.util.ArrayList;

public class Subject
{
    private String abbreviation;
    private String name;
    private Employee employee;
    private int lectureCount;
    private int practiseCount;
    private int seminarCount;
    private int weeksCount = 14;
    private Language language;
    private StudyForm studytype;
    private int year;
    private Term term;
    private Classification classification;
    private int defaultGroupSize = 24;
    ArrayList<StudyGroup> studyGroups;
}
