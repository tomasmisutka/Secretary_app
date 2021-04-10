package Common;

import java.util.ArrayList;

public class Employee
{
    private String firstName;
    private String lastName;
    private String fullName;
    private String privateEmail;
    private String jobEmail;
    private boolean isDoctoral;
    private double workLoad;
    private int workPoints = 0;
    private int workPointsEN = 0;
    private ArrayList<WorkLabel> workLabels;

    public Employee()
    {
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setPrivateEmail(String privateEmail)
    {
        this.privateEmail = privateEmail;
    }

    public void setJobEmail(String jobEmail)
    {
        this.jobEmail = jobEmail;
    }

    public void setDoctoral(boolean doctoral)
    {
        isDoctoral = doctoral;
    }

    public void setWorkLoad(double workLoad)
    {
        this.workLoad = workLoad;
    }

    public void setWorkPoints(int workPoints)
    {
        this.workPoints = workPoints;
    }

    public void setWorkPointsEN(int workPointsEN)
    {
        this.workPointsEN = workPointsEN;
    }

    public void setWorkLabels(ArrayList<WorkLabel> workLabels)
    {
        this.workLabels = workLabels;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getPrivateEmail()
    {
        return privateEmail;
    }

    public String getJobEmail()
    {
        return jobEmail;
    }

    public boolean isDoctoral()
    {
        return isDoctoral;
    }

    public double getWorkLoad()
    {
        return workLoad;
    }

    public int getWorkPoints()
    {
        return workPoints;
    }

    public int getWorkPointsEN()
    {
        return workPointsEN;
    }

    public ArrayList<WorkLabel> getWorkLabels()
    {
        return workLabels;
    }

    @Override
    public String toString()
    {
        return "Full name: " + this.fullName + ", private email: " + this.privateEmail + ", job email: " + this.jobEmail + ", is doctoral: " +
                this.isDoctoral + ", workload: " + this.workLoad + ", work points " + this.workPoints + ", work points EN: " +
                this.workPointsEN;
    }
}
