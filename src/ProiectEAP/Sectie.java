package ProiectEAP;

public class Sectie extends Post {
    private String nume;
    private String [] specAngajati;
    private Doctor[] doctori;
    private Angajat [] angajati;
    private int maxPacienti;

    public Sectie(String nume, String[] specAngajati, Doctor[] doctori, Angajat[] angajati, int maxPacienti) {
        super(nume, specAngajati, doctori, angajati);
        this.maxPacienti = maxPacienti;
    }

    public int getMaxPacienti() {
        return maxPacienti;
    }

    public void setMaxPacienti(int maxPacienti) {
        this.maxPacienti = maxPacienti;
    }
}
