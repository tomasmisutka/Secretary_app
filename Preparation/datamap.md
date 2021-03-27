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
  - array studyGroup
  
*NOTES*
    //predmety budeme davat do databazy SQL (moj pripad), a budu sa tam aspon zatial pridavat rucne, 
    //front-end: formular s pridanim predmetu...
    //tajomnik ma pod sebou zamestancov
    //bude pracovny stitok priradeny tajomnikom, a priradi tam zamestnanca k danemu predmetu
    
# 2. Institute staff

  ## Class - Employee
  - String name
  - String surname
  - String phoneNumber
  - String workNumber
  - String email
  - String workMail
  - Boolean isDoctorant
  - double workLoad // 0 - part time, 1 - full time, workload between 0.1 - 99.9%
  - int techedHoursCZ
  - int techedHoursEN
  - array workLabel // probably every employee needs list of work labels
  
  //everyone need own work label
  
# 3. Students count

  ## Class - StudyGroup
  - String abbreviation
  - String name
  - Enum TYPEOFSTUDY
  - int year
  - Enum TERM
  - int studentsCount
  
*NOTES
  
  //enumy na frontende by boli ideale take, ze si uzivatel nieco len zaklikne - priklad: LS vs ZS
  
# 4. WorkLoad list

  ## Class workLabel
  - 
  // every worklabel is created based on students grups count ... then should be visible for secretary to be able to match to any free employee
  // employees can not have more than 500 points for teaching! - they have another work! , but not less, because they have a full time!
  
# Additional functionality
  - send changes to employee's email address (work email)
