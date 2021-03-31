package ProiectEAP;

public class Spital {
    private String nume;
    private String adresa;
    private Sectie [] sectii;
    private Laborator [] laboratoare;
    private Programare [] programari;


    public Spital(String nume, String adresa, Sectie[] sectii, Laborator[] laboratoare, Programare [] programari) {
        this.nume = nume;
        this.adresa = adresa;
        this.sectii = sectii;
        this.laboratoare = laboratoare;
        this.programari = programari;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Sectie[] getSectii() {
        return sectii;
    }

    public void setSectii(Sectie[] sectii) {
        this.sectii = sectii;
    }

    public Laborator[] getLaboratoare() {
        return laboratoare;
    }

    public void setLaboratoare(Laborator[] laboratoare) {
        this.laboratoare = laboratoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Programare[] getProgramari() {
        return programari;
    }

    public void setProgramari(Programare[] programari) {
        this.programari = programari;
    }
}
