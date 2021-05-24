package proiecteap.database;

import proiecteap.clase.Angajat;
import proiecteap.clase.Doctor;
import proiecteap.clase.Pacient;
import proiecteap.database.repositories.AfectiuniRepository;
import proiecteap.database.repositories.AngajatRepository;
import proiecteap.database.repositories.DoctorRepository;
import proiecteap.database.repositories.PacientRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbEntryPoint {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        // TEST CONEXIUNE
        /*
        DBconnection DBconn = new DBconnection();
        //DBconn.testConn("127.0.0.1", 3306);
*/

        //Test operatiuni Doctori
/*
        DoctorRepository doctorRepository = new DoctorRepository();

        //INSERT

        Doctor d1 = new Doctor("Alexandru Georgescu", "Cardiolog", 56);
        Doctor d2 = new Doctor("Cosmin Petcu", "Oftalmolog", 34);
        doctorRepository.insertDoctor(d1);
        doctorRepository.insertDoctor(d2);

        //SELECT

        List <Doctor> allDoctori = new ArrayList<>();
        allDoctori = doctorRepository.selectDoctori();
        for (Doctor d: allDoctori)
        {
            d.getDetails();
        }

        //DELETE

        Doctor d3 = new Doctor();
        //d3.setVarsta(56);
        d3.setNume("Cosmin Petcu");
        d3.getDetails();
        doctorRepository.deleteDoctor(d3);

        //UPDATE

        Doctor d4 = new Doctor("Paul Marin", "Ortoped", 44);
        Doctor dc = new Doctor();
        dc.setID(1);

        doctorRepository.updateDoctor(dc, d4);
*/

        //Test operatiuni Angajati
/*
        AngajatRepository angajatRepository = new AngajatRepository();

        //INSERT

        Angajat a1 = new Angajat("Andrei Popescu", "Gardian", 28);
        Angajat a2 = new Angajat("Daniela Parvulescu", "Asistent", 31);
        angajatRepository.insertAngajat(a1);
        angajatRepository.insertAngajat(a2);

        //SELECT

        for(Angajat a:angajatRepository.selectAngajati()){
            a.getDetails();
        }

        //DELETE

        Angajat a3 = new Angajat();
        a3.setTitlu("Gardian");

        angajatRepository.deleteAngajat(a3);

        //UPDATE
        Angajat a4 = new Angajat("George Lucaci", "Gardian", 35);
        Angajat a5 = new Angajat("George Lucaci", "Receptioner", 35);
        angajatRepository.insertAngajat(a4);
        angajatRepository.updateAngajat(a4, a5);
*/

        //Test operatiuni Afectiuni
/*
        AfectiuniRepository afectiuniRepository = new AfectiuniRepository();

        //INSERT

        afectiuniRepository.insertAfectiune("otita");
        afectiuniRepository.insertAfectiune("pojar");

        //SELECT

        List<String> allAfectiuni = new ArrayList<>();

        allAfectiuni = afectiuniRepository.selectAfectiuni();

        for (String a:allAfectiuni){
            System.out.println(a);
        }

        //DELETE

        String s = "pojar";

        afectiuniRepository.deleteAfectiune(s);

        //UPDATE

        afectiuniRepository.insertAfectiune("grip");

        afectiuniRepository.updateAfectiune("grip", "gripa");
*/

        //Test operatiuni Pacienti
/*
        PacientRepository pacientRepository = new PacientRepository();

        //INSERT

        List<String> afectiuniP1 = new ArrayList<>();
        List<String> afectiuniP2 = new ArrayList<>();
        afectiuniP1.add("otita");
        afectiuniP1.add("cataracta");
        afectiuniP2.add("artrita");
        Pacient p1 = new Pacient("Gheorghe Marinescu", 62, afectiuniP1);
        Pacient p2 = new Pacient("Marinela Burlacu", 65, afectiuniP2);
        Pacient p3 = new Pacient("Alexandru Vasilescu", 54, afectiuniP2);

        pacientRepository.insertPacient(p1);
        pacientRepository.insertPacient(p2);
        pacientRepository.insertPacient(p3);


        //SELECT

        for (Pacient p:pacientRepository.selectPacienti())
        {
            p.getDetails();
        }


        //DELETE

        Pacient pd = new Pacient();
        pd.setNume("Gheorghe Marinescu");
        pacientRepository.deletePacient(pd);
*/


    }
}
