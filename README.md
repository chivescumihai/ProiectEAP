Proiect EAP 
Chivescu Mihai-Cristian
Grupa 253
Facultatea de matematica si informatica

Tema spital

Interfata persoana
- get si set nume, varsta

clasa Doctor implementeaza persoana
- private static int nr, pentru a memora numarul total de doctori, incrementat automat la declararea unui nou doctor
- private int ID, nr alocat fiecarui doctor
- private string nume
- private string specializare
- private int varsta

-get si set nume, specializare, varsta;
-get ID;
- getDetails, o functie care afiseaza toate detaliile despre un doctor

clasa Angajat implementeaza persoana
- private string nume
- private int varsta
- private String titlu

- get si set nume, titlu, varsta


clasa Pacient immplementeaza persoana
- private static int nr, pentru a memora numarul total de doctori, incrementat automat la declararea unui nou doctor
- private int ID, nr alocat fiecarui doctor
- private string nume
- private int varsta
- private string [] afectiuni

-get si set nume, specializare, varsta, afectiuni;
-get ID;


clasa Post
- protected String nume;
- protected String [] specAngajati, specializarile necesare postului;
- protected Doctor [] doctori;
- protected Angajat [] angajati;

- get si set nume, specAngajati, doctori, angajati;


clasa Sectie extinde Post
- private string nume
- private String [] specAngajati, specializarile angajatilor necesare sectiei
- private Doctor [] doctori, doctorii alocati sectiei
- private Angajat [] angajati, angajatii alocati sectiei
- private maxPacienti, nr max de pacienti admisi in acelasi timp in sectie

- get si set maxPacienti



clasa Laborator extinde Post
- private string nume
- private String [] specAngajati, specializarile angajatilor necesare sectiei
- private Doctor [] doctori, doctorii alocati sectiei
- private Angajat [] angajati, angajatii alocati sectiei
- private String [] echipament, masinariile si aparatele speciale necesare laboratorului;

-get si set echipament


clasa Date
- private int an, luna, zi, ora, minut, secunda

- set si get pentru an, luna, zi, ora, minut, secunda
- getData, o functie care returneaza un int [] care contine {an, luna, zi};
- getTime, o functie care returneaza un int [] care contine {ora, minut, secunda}; 
- getAll,  o functie care returneaza un int [] care contine {an, luna, zi, ora, minut, secunda};


clasa Programare
- private statin int nr
- private int ID
- private Pacient pacient
- private Date data
- private Sectie sectie
- private Doctor doctor

- get si set pentru pacient, data, sectie, doctor
- get ID



clasa Spital
- private String [] nume
- private String [] adresa
- private Sectie [] sectii
- private Laborator [] laboratoare
- private Programare [] programari

- set si get pentru nume, adresa, sectii, laboratoare, programari


clasa SortDoctor implementeaza Commparator<Doctor>
- va fi folosita pentru sortarea alfabetica a vectorilor de doctori din sectii/laboratoare/spitale

clasa Service
- contine functii pentru sortarea unui vector de doctori, angajati sau pacienti

clasa Validare
- contine functii de validare pentru majoritatea campurilor din majoritatea claselor
- validNume(String nume) - verifica daca numele unei persoane este valid
- validDoctor(Doctor doc) - verifica daca datele specifice ale unui doctor sunt valide
- validAngajat(Angajat ang) - verifica daca datele specifice ale unui angajat sunt valide
- validSectie(Sectie sec) - verifica daca datele specifice ale unei sectii sunt valide
- validLab - verifica daca datele specifice ale unui laborator sunt valide
- validData - verifica daca data introdusa are un format corect
- validPacient - verifica ddaca datele unui pacient sunt valide
- validProgramare - verifica daca o programare este valida
- validSpital - verifica daca datele membre ale unui spital sunt valide


