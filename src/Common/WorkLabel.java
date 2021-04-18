package Common;

import Common.Enums.EventType;
import Common.Enums.Language;

public class WorkLabel
{
    private String name;
    private Employee employee;
    private Subject subject;
    private EventType eventType;
    private int studentsCount = 11;
    private int hoursCount; //exams are not awarded!
    private int weeksCount;
    private Language language;
    private int totalPoints;

    public WorkLabel()
    {
    }

    public String getName()
    {
        return name;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public int getStudentsCount()
    {
        return studentsCount;
    }

    public int getHoursCount()
    {
        return hoursCount;
    }

    public int getWeeksCount()
    {
        return weeksCount;
    }

    public Language getLanguage()
    {
        return language;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public void setEventType(EventType eventType)
    {
        this.eventType = eventType;
    }

    public void setStudentsCount(int studentsCount)
    {
        this.studentsCount = studentsCount;
    }

    public void setHoursCount(int hoursCount)
    {
        this.hoursCount = hoursCount;
    }

    public void setWeeksCount(int weeksCount)
    {
        this.weeksCount = weeksCount;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public void setTotalPoints(int totalPoints)
    {
        this.totalPoints = totalPoints;
    }
}
