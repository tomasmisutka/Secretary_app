**last update: 27.3.2021**

# **** Models *****

# 1. Study plan

  ## Class - Subject
  - String abbreviation (unique identificator)
  - String name
  - Employee teacher
  - int lectureCount
  - int practiseCount
  - int seminarCount
  - int weeksCount (14 default, combined 1)
  - Enum LANGUAGE //CZ,EN
  - Enum TYPEOFSTUDY //Present, combined
  - int YEAR
  - Enum TERM //summer, winter
  - Enum CLASSIFICATION //zapocet, klasif. zapocet, skuska
  - int defaultGroupSize (24 default, 12 can be, 0 in combined)
  - List <StudyGroup> studyGroup
  
*NOTES*

    -front-end: add subject form
    
    -secretary is a leader of employees
    
    -secretary assign a workload to employee with current subject, and employee will be informed about changes through email
    
# 2. Institute staff

  ## Class - Employee
  - String name
  - String surname
  - String fullname (Name + Surname)
  - String phoneNumber
  - String jobPhone
  - String email
  - String jobMail
  - Boolean isDoctorant
  - double workLoad // 0 - part time, 1 - full time, workload between 0.01 - 0.99%
  - int techingCZHours //526? method?
  - int techingENHours //767? method?
  - List <WorkLabel> workLabel
  
  *NOTES*
  
# 3. Students

  ## Class - StudyGroup
  - String abbreviation
  - String name
  - Enum StudyType (Bachelors,Masters)
  - Enum StudyForm (present, combined)
  - int year
  - Enum TERM (winter, summer)
  - int studentsCount (default 36)
  - Enum language (cz,en)
  - List <Subject> subjects
  
*NOTES*
  
    -enums on front-end size should be very simple and clickable - example: Present or Combined form in simple JRadioButton component (JAVA)
  
# 4. WorkLoad list

  ## Class WorkLabel
  - String name
  - Employee employee (could be null)
  - Subject subject (could be null)
  - Enum type (lecture, seminar, practise, exam, clasification...)
  - Int studentsCount
  - Int hoursCount
  - Int weeksCount
  - Enum language
  - Int WorkloadPoints (12.5???) method ?
 
*NOTES*

  -every worklabel is created based on students grups count ... then should be visible for secretary to be able to match to any free employee
  
  -employees can not have more than 500 points for teaching! - they have another work! , but not less, because they have a full time!
  
# 5. Workload weights

  -this will be pulled in application start from DB and saved in GlobalConfig class
  
  - double lectureHour (1.8)
  - double practiseHour (1.2)
  - double seminarHour (1.2)
  - double lectureHourEN (2.4)
  - double practiseHourEN (1.8)
  - double seminarHourEN (1.8)
  - double midTermExamAward (0.2)
  - double clasificatedExamAward (0.3)
  - double examEward (0.4)
  - double midTermExamEN (0.2)
  - double clasificatedExamAwardEN (0.3)
  - double examEN (0.4)
  
# Additional functionality

  -send changes to employee's email address (job email)
