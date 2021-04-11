package Common;

import Common.Enums.Classification;
import Common.Enums.Language;

import java.util.ArrayList;

public class Subject
{
    private String abbreviation;
    private int weeksCount;
    private int lecturesCount;
    private int practicesCount;
    private int seminarsCount;
    private Classification classification;
    private Language language;
    private int defaultGroupSize;
    private ArrayList<StudyGroup> studyGroups;

    public Subject()
    {
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
