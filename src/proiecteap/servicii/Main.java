package proiecteap.servicii;

import proiecteap.clase.Date;
import proiecteap.clase.Doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) throws IOException {
        Validare validare = new Validare();
        Service service = new Service();

/*

        //Date, zile, ore
        Date data1 = new Date(2021, 11, 15, 12, 30, 0);
        Date data2 = new Date(2021, 5, 6, 15, 0,0 );

        //Doctori
        Doctor d1 = new Doctor("Andrei Gheorghe", "Chirurg" , 55);
        Doctor d2 = new Doctor("Daniel Cristea", "Radiolog" , 43);
        Doctor d3 = new Doctor("Gabriel Tintea", "Radiolog", 45);
        Doctor d4 = new Doctor("Bianca Dumitru", "Chirurg", 26);
        Doctor d5 = new Doctor("Andreea Petrea", "Chirurg", 27);


        //Angajati
        Angajat a1 = new Angajat("Gigel Marinescu", "Asistent", 34);
        Angajat a2 = new Angajat("Lucian Iordache", "Om de serviciu", 28);

        //Lista de posibile afectiuni ale pacietilor
        List<String> afectiuniP1 = new ArrayList<String>();
        afectiuniP1.add("Reumatism");

        //Pacienti
        Pacient p1 = new Pacient("Andreea Popescu", 34, afectiuniP1);

        // Date sectie1
        List<String> specSectie1 = new ArrayList<String>();
        specSectie1.add("Chirurg");
        specSectie1.add("Asistent");

        List<Doctor> docSectie1 = new ArrayList<Doctor>();

        List<Angajat> angSectie1 = new ArrayList<Angajat>();
        angSectie1.add(a1);


        //Date lab1
        List<Doctor> docLab1 = new ArrayList<Doctor>();
        service.addDoctor(docLab1, d2);
        service.addDoctor(docLab1, d3);

        List<Angajat> angLab1 = new ArrayList<Angajat>();
        service.addAngajat(angLab1, a2);

        List<String> specLab1 = new ArrayList<String>();
        specLab1.add("Radiolog");
        specLab1.add("Om de serviciu");

        //Sectii si laboratoare
        Sectie sectie1 = new Sectie("Chirurgie generala", specSectie1, docSectie1 , angSectie1, 10);

        service.addDoctor(docSectie1, d1);
        service.addDoctor(docSectie1, d4);
        service.addDoctor(docSectie1, d5);

        Laborator lab1 = new Laborator("Radioterapie", specLab1, docLab1, angLab1, specLab1);

        //Programari
        Programare programare1 = new Programare(p1, data1, sectie1, d1);

        //Lista sectii spital 1
        List<Sectie> sectiiSpital1 = new ArrayList<Sectie>();
        service.addSectie(sectiiSpital1, sectie1);

        //Lista laboratoare spital 1
        List<Laborator> laboratoareSpital1 = new ArrayList<Laborator>();
        service.addLaborator(laboratoareSpital1, lab1);

        //Lista programari spital 1
        List<Programare> programariSpital1 = new ArrayList<Programare>();
        service.addProgramare(programariSpital1, programare1);


        //Spitale
        Spital spital1 = new Spital("Spitalul Judetean Constanta", "Bulevardul Mamaia nr.253", sectiiSpital1, laboratoareSpital1, programariSpital1);

        for (Doctor i: service.getSortedDoctors(docSectie1))
        {
            i.getDetails();
        }

 */

        DateService dateService = DateService.getInstance();
        DoctorService doctorService = DoctorService.getInstance();

        //Test citire si afisare date din/in fisier
/*
//Citire
    List<Date> testDateIn = new ArrayList<Date>();
    String dateFilepath = "E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\Fisiere CSV\\datein.csv";
    testDateIn = dateService.citireDate(dateFilepath);
        for (Date d:testDateIn)
        {
            d.showAll();
        }

//Afisare
        List<Date> testDateOut = new ArrayList<Date>();
        Date dateOut1 = new Date (2021, 4, 13, 10, 0, 0);
        Date dateOut2 = new Date (2021, 5, 6, 15, 45, 30);
        service.addDate(testDateOut, dateOut1);
        service.addDate(testDateOut, dateOut2);

        dateService.afisareDate(testDateOut);
*/

        //Test citire si afisare doctori din/in fisier

    List<Doctor> testDoctoriIn = new ArrayList<Doctor>();
    String doctorFilepath = "E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\Fisiere CSV\\doctorin.csv";
    testDoctoriIn = doctorService.citireDoctori(doctorFilepath);
        for (Doctor d: testDoctoriIn)
        {
            d.getDetails();
        }

        Doctor docOut1 = new Doctor("Andrei Parvulescu", "Ortoped", 54);
        Doctor docOut2 = new Doctor("Miruna Tibrea", "Neurochirurg", 32);
        List<Doctor> testDoctorOut = new ArrayList<Doctor>();
        service.addDoctor(testDoctorOut, docOut1);
        service.addDoctor(testDoctorOut, docOut2);

        doctorService.afisareDoctori(testDoctorOut);

    }

}