package Common;

import Common.Enums.Classification;

import java.util.ArrayList;

public class Subject
{
    private String abbreviation;
    private String name;
    private int weeksCount = 14;
    private int lecturesCount;
    private int practicesCount;
    private int seminarsCount;
    private Classification classification;
    private int defaultGroupSize = 24;
    private ArrayList<StudyGroup> studyGroups;
}
