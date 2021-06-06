package Common;

import Common.Enums.Classification;
import Common.Enums.Language;

import java.util.ArrayList;

public class Subject
{
    private int id;
    private String abbreviation = "";
    private int weeksCount = 14;
    private int lecturesCount = 0;
    private int practicesCount = 0;
    private int seminarsCount = 0;
    private Classification classification = Classification.EXAM;
    private Language language = Language.CZ;
    private int defaultGroupSize = 24;
    private ArrayList<StudyGroup> studyGroups = new ArrayList<>();

    public Subject()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public int getWeeksCount()
    {
        return weeksCount;
    }

    public int getLecturesCount()
    {
        return lecturesCount;
    }

    public int getPracticesCount()
    {
        return practicesCount;
    }

    public int getSeminarsCount()
    {
        return seminarsCount;
    }

    public Classification getClassification()
    {
        return classification;
    }

    public Language getLanguage()
    {
        return language;
    }

    public int getDefaultGroupSize()
    {
        return defaultGroupSize;
    }

    public ArrayList<StudyGroup> getStudyGroups()
    {
        return studyGroups;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public void setWeeksCount(int weeksCount)
    {
        this.weeksCount = weeksCount;
    }

    public void setLecturesCount(int lecturesCount)
    {
        this.lecturesCount = lecturesCount;
    }

    public void setPracticesCount(int practicesCount)
    {
        this.practicesCount = practicesCount;
    }

    public void setSeminarsCount(int seminarsCount)
    {
        this.seminarsCount = seminarsCount;
    }

    public void setClassification(Classification classification)
    {
        this.classification = classification;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public void setDefaultGroupSize(int defaultGroupSize)
    {
        this.defaultGroupSize = defaultGroupSize;
    }

    public void setStudyGroups(ArrayList<StudyGroup> studyGroups)
    {
        this.studyGroups = studyGroups;
    }
}
