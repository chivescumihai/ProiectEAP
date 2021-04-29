package proiecteap.clase;
import java.util.List;

public class Post {
    protected String nume;
    protected List<String> specAngajati;
    protected List<Doctor> doctori;
    protected List<Angajat> angajati;

    public Post(String nume, List<String> specAngajati, List<Doctor> doctori, List<Angajat> angajati) {
        this.nume = nume;
        this.specAngajati = specAngajati;
        this.doctori = doctori;
        this.angajati = angajati;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<String> getSpecAngajati() {
        return specAngajati;
    }

    public void setSpecAngajati(List<String> specAngajati) {
        this.specAngajati = specAngajati;
    }

    public List<Doctor> getDoctori() {
        return doctori;
    }

    public void setDoctori(List<Doctor> doctori) {
        this.doctori = doctori;
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }
}
