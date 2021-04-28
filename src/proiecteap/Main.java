package proiecteap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;

import javax.print.Doc;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) throws IOException {
        Validare validare = new Validare();
        Service service = new Service();
        DateService dS = DateService.getInstance();
        Date da = new Date(2021, 10, 15, 12, 0, 0);


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

    //Test citire date din fisier
    List<Date> testDate = new ArrayList<Date>();
    String filepath = "E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\datein.csv";
    testDate = dS.citireDate(filepath);
        for (Date d:testDate)
        {
            d.showAll();
        }




    }
}