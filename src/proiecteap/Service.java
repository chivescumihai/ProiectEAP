package proiecteap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    Validare validare = new Validare();
    AuditService aS = new AuditService();

    public void addAngajat(List<Angajat> v, Angajat a) throws IOException {
        boolean angOK = validare.validAngajat(a);
        if (angOK == true)
        {
            v.add(a);
            aS.scrie("addAngajat");
        }
        else
            validare.validAngajat(a);
    }

    public void addDoctor(List<Doctor> v, Doctor d) throws IOException {
        boolean docOK = validare.validDoctor(d);
        aS.scrie("addDoctor");
        if(docOK == true)
        {
            v.add(d);

        }
        else
            validare.validDoctor(d);
    }

    public void addSectie(List<Sectie> v, Sectie s) throws IOException {
        boolean secOK = validare.validSectie(s);
        if (secOK == true)
        {
            v.add(s);
            aS.scrie("addSectie");
        }
        else
            validare.validSectie(s);
    }

    public void addLaborator(List<Laborator> v, Laborator l) throws IOException {
        boolean labOK = validare.validLab(l);
        if(labOK == true)
        {
            v.add(l);
            aS.scrie("addLaborator");
        }
        else
            validare.validLab(l);
    }

    public void addProgramare(List<Programare> v, Programare p) throws IOException {
        boolean progOK = validare.validProgramare(p);
        if (progOK == true)
        {
            v.add(p);
            aS.scrie("addProgramare");
        }
        else
            validare.validProgramare(p);
    }

    public void addSpital(List<Spital> v, Spital s) throws IOException {
        boolean spitalOK = validare.validSpital(s);
        if (spitalOK == true)
        {
            v.add(s);
            aS.scrie("addSpital");
        }
        else
            validare.validSpital(s);
    }

    public void afisDoctori (Spital s) throws IOException {
        for (Sectie sectie: s.getSectii())
        {
            System.out.println("Sectia "+sectie.getNume()+" are urmatorii doctori: \n");
            for (Doctor d: sectie.getDoctori())
            {
                d.getDetails();
            }
        }

        for (Laborator laborator: s.getLaboratoare())
        {
            System.out.println("Laboratorul "+laborator.getNume()+" are urmatorii doctori: \n");
            for (Doctor d: laborator.getDoctori())
            {
                d.getDetails();
            }
        }
        aS.scrie("afisDoctori");
    }

    public void afisAngajati (Spital s) throws IOException {
        for (Sectie sectie: s.getSectii())
        {
            System.out.println("Sectia "+sectie.getNume()+" are urmatorii angajati: ");
            for (Angajat a: sectie.getAngajati())
            {
                a.getDetails();
            }
        }

        for (Laborator laborator: s.getLaboratoare())
        {
            System.out.println("Sectia "+laborator.getNume()+" are urmatorii angajati: ");
            for (Angajat a: laborator.getAngajati())
            {
                a.getDetails();
            }
        }
        aS.scrie("afisAngajati");
    }

    public List<Programare> cautaProgPacient(Spital s, String nume) throws IOException {
        List<Programare> prog = s.getProgramari();
        List<Programare> aux = new ArrayList<Programare>();
        for (Programare p: prog)
        {
            if (p.getPacient().getNume().equals(nume))
            {
                addProgramare(aux, p);
            }
        }
        aS.scrie("cautaProgPacient");
        return aux;
    }

    public List<Doctor> getSortedDoctors(List<Doctor> v) throws IOException {
        Collections.sort(v, new SortDoctor());
        aS.scrie("getSortedDoctors");
        return v;
    }

    }
