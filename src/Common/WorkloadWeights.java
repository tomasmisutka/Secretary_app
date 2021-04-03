package Common;

public class WorkloadWeights
{
    private final double lectureHour;
    private final double practiseHour;
    private final double seminarHour;
    private final double lectureHourEN;
    private final double practiseHourEN;
    private final double seminarHourEN;
    private final double midTermExam;
    private final double classifiedExam;
    private final double exam;
    private final double midTermExamEN;
    private final double classifiedExamEN;
    private final double examEN;

    public WorkloadWeights(double lectureHour, double practiseHour, double seminarHour, double lectureHourEN,
                           double practiseHourEN, double seminarHourEN, double midTermExam, double classifiedExam,
                           double exam, double midTermExamEN, double classifiedExamEN, double examEN)
    {
        this.lectureHour = lectureHour;
        this.practiseHour = practiseHour;
        this.seminarHour = seminarHour;
        this.lectureHourEN = lectureHourEN;
        this.practiseHourEN = practiseHourEN;
        this.seminarHourEN = seminarHourEN;
        this.midTermExam = midTermExam;
        this.classifiedExam = classifiedExam;
        this.exam = exam;
        this.midTermExamEN = midTermExamEN;
        this.classifiedExamEN = classifiedExamEN;
        this.examEN = examEN;
    }

    public double getLectureHour()
    {
        return lectureHour;
    }

    public double getPractiseHour()
    {
        return practiseHour;
    }

    public double getSeminarHour()
    {
        return seminarHour;
    }

    public double getLectureHourEN()
    {
        return lectureHourEN;
    }

    public double getPractiseHourEN()
    {
        return practiseHourEN;
    }

    public double getSeminarHourEN()
    {
        return seminarHourEN;
    }

    public double getMidTermExam()
    {
        return midTermExam;
    }

    public double getClassifiedExam()
    {
        return classifiedExam;
    }

    public double getExam()
    {
        return exam;
    }

    public double getMidTermExamEN()
    {
        return midTermExamEN;
    }

    public double getClassifiedExamEN()
    {
        return classifiedExamEN;
    }

    public double getExamEN()
    {
        return examEN;
    }

    @Override
    public String toString()
    {
        return "Lectures: " + this.lectureHour + " Practises: " + this.practiseHour + " Seminars: " + this.seminarHour +
                " Lectures EN: " + this.lectureHourEN + " Practises EN: " + this.practiseHourEN + " Seminars EN: " +
                this.seminarHourEN + " Mid term exam: " + this.midTermExam + " Classified exam: " + this.classifiedExam +
                " Exam: " + this.exam + " Mid term exam EN: " + this.midTermExamEN + " Classified exam EN: " + this.classifiedExamEN +
                " Exam EN: " + this.examEN;
    }
}
