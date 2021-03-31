package ProiectEAP;

public class Laborator extends Post{
    private String nume;
    private String [] specAngajati;
    private Doctor[] doctori;
    private Angajat [] angajati;
    private String [] echipament;


    public Laborator(String nume, String[] specAngajati, Doctor[] doctori, Angajat[] angajati, String[] echipament) {
        super(nume, specAngajati, doctori, angajati);
        this.echipament = echipament;
    }

    public String[] getEchipament() {
        return echipament;
    }

    public void setEchipament(String[] echipament) {
        this.echipament = echipament;
    }
}
