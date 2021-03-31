package ProiectEAP;

public class Angajat implements Persoana{
    private String nume;
    private String titlu;
    private int varsta;

    public Angajat(String nume, String titlu, int varsta) {
        this.nume = nume;
        this.titlu = titlu;
        this.varsta = varsta;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;

    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public int getVarsta() {
        return this.varsta;
    }

    public String getTitlu() {
        return this.titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
}
