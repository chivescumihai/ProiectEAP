package ProiectEAP;

public class Post {
    protected String nume;
    protected String [] specAngajati;
    protected Doctor [] doctori;
    protected Angajat [] angajati;

    public Post(String nume, String[] specAngajati, Doctor[] doctori, Angajat[] angajati) {
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

    public String[] getSpecAngajati() {
        return specAngajati;
    }

    public void setSpecAngajati(String[] specAngajati) {
        this.specAngajati = specAngajati;
    }

    public Doctor[] getDoctori() {
        return doctori;
    }

    public void setDoctori(Doctor[] doctori) {
        this.doctori = doctori;
    }

    public Angajat[] getAngajati() {
        return angajati;
    }

    public void setAngajati(Angajat[] angajati) {
        this.angajati = angajati;
    }
}
