last update: 13.2.2021

# **** Models *****

## 1. Subject
  
  - String skratka
  - String nazov
  - Zamestnanec vyucujuci
  - int pocetHodinPrednasok
  - int pocetHodinCviceni
  - int pocetHodinSeminarov
  - int pocetTyzdnovSemestra
  - Enum vyucovaciJazyk //CZ,EN
  - Enum typStudia //Prezencne, kombinovane
  - int rocnik
  - Enum semester //LS, ZS
  - Enum sposobUkoncenia predmetu //zapocet, klasif. zapocet, skuska
  - int predvolenaVelkostSkupiny
  
*Poznamky*

    //predmety budeme davat do databazy SQL (moj pripad), a budu sa tam aspon zatial pridavat rucne, 
    //front-end: formular s pridanim predmetu...
    //tajomnik ma pod sebou zamestancov
    //bude pracovny stitok priradeny tajomnikom, a priradi tam zamestnanca k danemu predmetu
    
2) Zemestnanci   
    
Trieda - zamestnanec

*atributy*

  - String meno
  - String priezvisko
  - String telCislo
  - String pracCislo
  - String email
  - String pracovnyEmail
  - Boolean jeDoktorant
  - double druhPracovnehoUvazku // 0 - dohoda, 1 - full time, medzi tym uvazok na x %
  - int kolkoHdinUcivJazykuCZ
  - int kolkoHdinUcivJazykuEN
  
  //kazdy musi mat este list Stitkov...
  
3) Pocet studentov

Trieda - Studijna skupina

*atributy*

  - String skratka
  - String nazov
  - Enum typStudia
  - int rocnik
  - Enum semester
  - int pocetStudentov
  
*Poznamky
  
  //enumy na frontende by boli ideale take, ze si uzivatel nieco len zaklikne - priklad: LS vs ZS
  
4)   
      
#EN#

//comming soon
