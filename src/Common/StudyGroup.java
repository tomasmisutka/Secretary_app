package Common;

import Common.Enums.Language;
import Common.Enums.StudyForm;
import Common.Enums.StudyType;
import Common.Enums.Term;

public class StudyGroup
{
    private String abbreviation = "";
    private int year = 2021;
    private Term term = Term.WINTER;
    private int studentsCount = 36;
    private StudyForm studyForm = StudyForm.PRESENT;
    private StudyType studyType = StudyType.BACHELORS;
    private Language language = Language.CZ;

    public StudyGroup()
    {
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public int getYear()
    {
        return year;
    }

    public Term getTerm()
    {
        return term;
    }

    public int getStudentsCount()
    {
        return studentsCount;
    }

    public StudyForm getStudyForm()
    {
        return studyForm;
    }

    public StudyType getStudyType()
    {
        return studyType;
    }

    public Language getLanguage()
    {
        return language;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setTerm(Term term)
    {
        this.term = term;
    }

    public void setStudentsCount(int studentsCount)
    {
        this.studentsCount = studentsCount;
    }

    public void setStudyForm(StudyForm studyForm)
    {
        this.studyForm = studyForm;
    }

    public void setStudyType(StudyType studyType)
    {
        this.studyType = studyType;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }
}
