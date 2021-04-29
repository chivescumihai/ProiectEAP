package proiecteap.clase;
import java.util.List;

public class Sectie extends Post {
    private int maxPacienti;

    public Sectie(String nume, List<String> specAngajati, List<Doctor> doctori, List<Angajat> angajati, int maxPacienti) {
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
