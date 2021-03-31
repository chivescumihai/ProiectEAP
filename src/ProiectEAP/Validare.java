package ProiectEAP;


public class Validare {
    String [] exempleSectii = {"Urgente", "Chirurgie generala", "Cardiologie", "Chirurgie cardiovasculara", "Chirurgie plastica", "Chirurgie si ortopedie pediatrica", "Nefrologie", "Neurochirurgie", "Neurologie", "Obstretica Ginecologie", "Oftalmologie", "Oncologie", "Traumatologie", "Psihiatrie", "Urologie"};
    String [] exempleLaboratoare = {"Hemodializa", "Biologie Moleculara", "Radiologie", "Imagistica medicala", "Radioterapie", "Recuperare si medicina fizica", "Anatomie patologica", "Transfuzie sanguina"};
    String [] exempleSpecializari = {"Chirurg", "Cardiolog", "Chirurg cardiovascular", "Chirurg plastician", "Chirurg pediatru", "Ortoped", "Nefrolog", "Neurochirurg", "Neurochirurg", "Neurolog", "Ginecolog", "Oftalmolog", "Oncologist", "Psihiatru", "Psiholog", "Urolog"};
    String [] exempleSpecializariLab = {"Hematolog", "Biolog", "Radiolog", "Radioterapeut", "Chiropractor", "Asistent laborant"};
    String [] exempleAngajati = {"Secretara", "Asistent", "Administrator", "Gardian", "Director", "Receptioner", "Menajera", "Om de serviciu"};


    public boolean validNume (String nume) {
        return nume.matches("(^[A-Z][a-z]+ [A-Z][a-z]+$)|(^[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+$)|(^[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+$)");
    };

    public boolean validDoctor (Doctor doc) {
        boolean numeOK = validNume(doc.getNume());
        if (numeOK == false)
        {
            System.out.println("Nume invalid.");
            return false;
        }

        boolean specOK = false;
        for (String i:exempleSpecializari)
        {
            if (doc.getSpecializare().equals(i))
            {
                specOK = true;
            }
        }

        for (String i:exempleSpecializariLab)
        {
            if (doc.getSpecializare().equals(i))
            {
                specOK = true;
            }
        }

        if (specOK == false)
        {
            System.out.println("Specializare doctor invalida");
            return false;
        }

        boolean varstaOK = false;
        if (doc.getVarsta() >= 25 & doc.getVarsta() <= 65)
        {
            varstaOK = true;
        }

        if (varstaOK == false)
        {
            System.out.println("Varsta doctor invalida");
            return false;
        }

        return true;
    }

    public boolean validAngajat (Angajat ang) {

        boolean numeOK = validNume(ang.getNume());
        if (numeOK == false)
        {
            System.out.println("Nume angajat invalid");
            return false;
        }

        boolean titluOK = false;
        for (String i:exempleAngajati)
        {
            if (ang.getTitlu().equals(i))
            {
                titluOK = true;
            }
        }

        if (titluOK == false)
        {
            System.out.println("Titlu angajat invalid");
            return false;
        }

        boolean varstaOK = false;

        if (ang.getVarsta() >= 18 & ang.getVarsta() <= 65)
        {
            varstaOK = true;
        }

        if (varstaOK == false)
        {
            System.out.println("Varsta angajat invalida");
            return false;
        }

        return true;
    }

    public boolean validSectie (Sectie sec) {

        boolean numeOK = false;
        for (String i:exempleSectii)
        {
            if (sec.getNume().equals(i))
            {
                numeOK = true;
            }
        }

        if (numeOK == false)
        {
            System.out.println("Nume sectie invalid");
            return false;
        }

        for (Doctor i:sec.getDoctori())
        {
            boolean doctorOK = validDoctor(i);
            if (doctorOK == false)
            {
                System.out.println("Doctorul "+ i.getNume()+" este declarat necorespunzator.");
                return false;
            }

            boolean specDoctorOK = false;
            for (String j:sec.getSpecAngajati())
            {
                if (i.getSpecializare().equals(j))
                {
                    specDoctorOK = true;
                }
            }

            if (specDoctorOK == false)
            {
                System.out.println("Doctorul "+i.getNume()+" are specializarea "+ i.getSpecializare() +", necorespunzatoare sectiei "+ sec.getNume());
                return false;
            }
        }

        for (Angajat i:sec.getAngajati())
        {
            boolean angajatOK = validAngajat(i);
            if (angajatOK == false)
            {
                System.out.println("Angajatul "+ i.getNume()+" este declarat necorespunzator.");
                return false;
            }

            boolean titluAngOK = false;
            for (String j:sec.getSpecAngajati())
            {
                if (i.getTitlu().equals(j))
                {
                    titluAngOK = true;
                }
            }

            if (titluAngOK == false)
            {
                System.out.println("Angajatul "+i.getNume()+" are titlul "+i.getTitlu()+", necorespunzator sectiei "+sec.getNume());
                return false;
            }
        }

        return true;
    }

    public boolean validLab (Laborator lab) {

        boolean numeOK = false;
        for (String i:exempleLaboratoare)
        {
            if (lab.getNume().equals(i))
            {
                numeOK = true;
            }
        }

        if (numeOK == false)
        {
            System.out.println("Nume laborator invalid");
            return false;
        }

        for (Doctor i:lab.getDoctori())
        {
            boolean doctorOK = validDoctor(i);
            if (doctorOK == false)
            {
                System.out.println("Doctorul "+ i.getNume()+" este declarat necorespunzator : \n" + validDoctor(i));
                return false;
            }

            boolean specDoctorOK = false;
            for (String j:lab.getSpecAngajati())
            {
                if (i.getSpecializare().equals(j))
                {
                    specDoctorOK = true;
                }
            }

            if (specDoctorOK == false)
            {
                System.out.println("Doctorul "+i.getNume()+" are specializarea "+ i.getSpecializare() +", necorespunzatoare laboratorului "+ lab.getNume());
                return false;
            }
        }

        for (Angajat i:lab.getAngajati())
        {
            boolean angajatOK = validAngajat(i);
            if (angajatOK == false)
            {
                System.out.println("Angajatul "+ i.getNume()+" este declarat necorespunzator : \n" + validAngajat(i));
                return false;
            }

            boolean titluAngOK = false;
            for (String j:lab.getSpecAngajati())
            {
                if (i.getTitlu().equals(j))
                {
                    titluAngOK = true;
                }
            }

            if (titluAngOK == false)
            {
                System.out.println("Angajatul "+i.getNume()+" are titlul "+i.getTitlu()+", necorespunzator laboratorului "+lab.getNume());
                return false;
            }
        }

        return true;
    }

    public boolean validData (Date d) {
        boolean anOK = false;
        if (d.getAn() >= 2021)
        {
            anOK = true;
        }

        if (anOK == false)
        {
            System.out.println("An invalid : "+d.getAn());
            return false;
        }

        boolean lunaOK = false;
            if (d.getLuna() >= 1 & d.getLuna() <= 12)
            {
                lunaOK = true;
            }

        if (lunaOK == false)
        {
            System.out.println("Luna invalida : "+d.getLuna());
            return false;
        }


        boolean ziuaOK = false;
        switch (d.getLuna()) {
            case 1:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 2:
                if (d.getAn()%4 == 0)
                    if (d.getZiua()>= 1 & d.getZiua() <= 29)
                        ziuaOK = true;
                else
                    if (d.getZiua()>= 1 & d.getZiua() <= 28)
                        ziuaOK = true;
            case 3:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 4:
                if (d.getZiua()>= 1 & d.getZiua() <= 30)
                    ziuaOK = true;
            case 5:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 6:
                if (d.getZiua()>= 1 & d.getZiua() <= 30)
                    ziuaOK = true;
            case 7:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 8:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 9:
                if (d.getZiua()>= 1 & d.getZiua() <= 30)
                    ziuaOK = true;
            case 10:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
            case 11:
                if (d.getZiua()>= 1 & d.getZiua() <= 30)
                    ziuaOK = true;
            case 12:
                if (d.getZiua()>= 1 & d.getZiua() <= 31)
                    ziuaOK = true;
        }

        if (ziuaOK == false)
        {
            System.out.println("Zi invalida : "+d.getZiua());
            return false;
        }

        boolean oraOK = false;

        if (d.getOra() >= 0 & d.getOra() <= 23)
        {
            oraOK = true;
        }

        if (oraOK == false)
        {
            System.out.println("Ora invalida : "+d.getOra());
            return false;
        }

        boolean minutOK = false;

        if (d.getMinut()>= 0 & d.getMinut() <= 59)
        {
            minutOK = true;
        }

        if (minutOK == false)
        {
            System.out.println("Minut invalid : "+d.getMinut());
            return false;
        }

        boolean secundaOK = false;

        if (d.getSecunda()>= 0 & d.getSecunda() <= 59)
        {
            secundaOK = true;
        }

        if (secundaOK == false)
        {
            System.out.println("Secunda invalida : "+d.getMinut());
            return false;
        }

        return true;
    }

    public boolean validPacient (Pacient p) {
        boolean numeOK = validNume(p.getNume());

        if (numeOK == false)
        {
            System.out.println("Numele pacientului "+p.getNume()+" este necorespunzator.");
            return false;
        }

        return true;
    }

    public boolean validProgramare (Programare prog) {
        boolean pacientOK = validPacient(prog.getPacient());

        if (pacientOK == false)
        {
            System.out.println("Pacientul "+prog.getPacient().getNume()+" a fost declarat necorespunzator.");
            return false;
        }

        boolean dataOK = validData(prog.getData());

        if (dataOK == false)
        {
            System.out.println("Data programarii "+prog.getID()+" este declarata necorespunzator : "+prog.getData().getAll());
            return false;
        }

        boolean sectieOK = validSectie(prog.getSectie());

        if (sectieOK == false)
        {
            System.out.println("Sectia "+prog.getSectie()+" pentru programarea "+prog.getID()+" a fost declarata necorespunzator.");
            return false;
        }

        boolean doctorOK = validDoctor(prog.getDoctor());

        if (doctorOK == false)
        {
            System.out.println("Doctorul "+prog.getDoctor().getNume()+" a fost declarat necorespunzator.");
            System.out.println("Eroarea este :" + validDoctor(prog.getDoctor()));
            return false;
        }
        return true;
    }

    public boolean validSpital (Spital spital) {

        for (Sectie s: spital.getSectii())
        {
            boolean sectieOK = validSectie(s);

           if (sectieOK == false)
           {
               System.out.println("Sectia "+s.getNume()+" din spitalul "+spital.getNume()+" a fost declarata necorespunzator.");
               System.out.println(validSectie(s));
               return false;
           }
        }

        for (Laborator lab: spital.getLaboratoare())
        {
            boolean labOK = validLab(lab);

            if (labOK == false)
            {
                System.out.println("Laboratorul "+ lab.getNume()+" din spitalul "+spital.getNume()+" a fost declarat necorespunzator.");
                System.out.println(validLab(lab));
                return false;
            }
        }

        for (Programare prog:spital.getProgramari())
        {
            boolean progOK = validProgramare(prog);

            if (progOK == false)
            {
                System.out.println("Programarea cu id-ul "+prog.getID()+" de la spitalul "+spital.getNume()+", sectia "+prog.getSectie().getNume()+" a fost declarata necorespunzator.");
                System.out.println(validProgramare(prog));
                return false;
            }
        }

        return true;
    }




}
