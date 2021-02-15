**last update: 15.2.2021**

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
  
*NOTES*
    //predmety budeme davat do databazy SQL (moj pripad), a budu sa tam aspon zatial pridavat rucne, 
    //front-end: formular s pridanim predmetu...
    //tajomnik ma pod sebou zamestancov
    //bude pracovny stitok priradeny tajomnikom, a priradi tam zamestnanca k danemu predmetu
    
# 2. Employees   

  - String name
  - String surname
  - String phoneNumber
  - String workNumber
  - String email
  - String workMail
  - Boolean isDoctorant
  - double workLoad // 0 - dohoda, 1 - full time, medzi tym uvazok na x %
  - int techedHoursCZ
  - int techedHoursEN
  
// everyone need own tag
  
# 3. Study group

  - String abbreviation
  - String name
  - Enum TYPEOFSTUDY
  - int year
  - Enum TERM
  - int studentsCount
  
*NOTES
  
  //enumy na frontende by boli ideale take, ze si uzivatel nieco len zaklikne - priklad: LS vs ZS
  
# 4.
