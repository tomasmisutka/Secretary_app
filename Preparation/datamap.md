MODELY:

1) Studijne plany
  
  Trieda - Predmet
    atributy: - predmet, nazov, vyucujuci (zatial nie)*, pocet hodin prednasok, pocet hodin seminarov, pocet hodin cviceni, pocet tyzdnov, v ktorych sa prednasa, a jazyk v ktorom sa prednasa (CZ/EN), studium - (Prezencne, kombinovane), rocnik, semester (LS,ZS), sposob ukoncenia predmetu (zapocet, klasifikovany zapocet, skuska) este cislo defaultneho velkosti skupiny
    
    //predmety budeme davat do databazy SQL (moj pripad), a budu sa tam aspon zatial pridavat rucne, 
    //front-end: formular s pridanim predmetu...
    //tajomnik ma pod sebou zamestancov
    //*tu bude pracovny stitok priradeny tajomnikom, a priradi tam samotneho zamestnanca
    
2) Zemestnanec    
    
    Trieda - zamestnanec
      atributy: meno, priezvisko, mob. telefon, prac. telefon, email, pracovny email, je doktorant?, velkost pracovnej zmluvy (double medzi 0 a 1), //0 dohoda, 1 full time, cislo kolko hodin mu zabera vyuka v CZ, cislo hodin vyuky v EN
