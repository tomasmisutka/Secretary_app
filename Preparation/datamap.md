**last update: 16.2.2021**

# **** Models *****

# 1. Study plan

  ## Class - Subject
  - String abbreviation
  - String name
  - Employee teacher
  - int lectureCount
  - int practiseCount
  - int seminarCount
  - int weeksCount
  - Enum LANGUAGE //CZ,EN
  - Enum TYPEOFSTUDY //Prezencne, kombinovane
  - int YEAR
  - Enum TERM //LS, ZS
  - Enum CLASSIFICATION //zapocet, klasif. zapocet, skuska
  - int defaultGroupSize
  - array studyGroup //probably
  
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
  
  // employees can not have more than 500 points for teaching! - they have another work! , but not less, because they have a full time!
  
# Additional functionality
  -
