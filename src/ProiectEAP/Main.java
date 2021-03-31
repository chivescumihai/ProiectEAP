package ProiectEAP;
import javax.print.Doc;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        Validare validare = new Validare();

        Doctor d1 = new Doctor("Andrei Gheorghe", "Chirurg" , 55);
        Doctor d2 = new Doctor("Daniel Cristea", "Radiolog" , 43);

        Angajat a1 = new Angajat("Gigel Marinescu", "Asistent", 34);
        Angajat a2 = new Angajat("Lucian Iordache", "Om de serviciu", 28);

        String [] afectiuniP1 = {"Reumatism"};
        Pacient p1 = new Pacient("Andreea Popescu", 34, afectiuniP1);
        //Programare programare = new Programare();

        String [] specSectie1 = { "Chirurg", "Asistent"};

        Doctor [] docSectie1 = {d1};
        Angajat [] angSectie1 = {a1};
        Sectie sectie1 = new Sectie("Chirurgie generala", new String [] {"Chirurg", "Asistent"}, docSectie1 , angSectie1, 10);
        Laborator lab1 = new Laborator("Radioterapie", new String[]{"Radiolog", "Om de serviciu"}, new Doctor[]{d2}, new Angajat[]{a2}, new String[]{"Tomograf", "Sistem imagistica RMN"});

       // for (String i:sectie1.getSpecAngajati())
       //   System.out.print(i+" ");
        //System.out.println(sectie1.getSpecAngajati());

        Programare prog1 = new Programare(p1, new Date(2021, 15, 5, 10, 0, 0), sectie1, d1);

        Spital spital1 = new Spital("Spitalul Judetean Constanta","Bulevardul Tomis nr 25", new Sectie[]{sectie1}, new Laborator[]{lab1}, new Programare[]{prog1});
        System.out.println(validare.validSpital(spital1));
        //System.out.println(validare.validSectie(sectie1));

        //d1.getDetails();
        //d2.getDetails();



    }
}
