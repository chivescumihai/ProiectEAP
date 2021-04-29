package proiecteap.clase;
import java.util.List;

public class Spital {
    private String nume;
    private String adresa;
    private List<Sectie> sectii;
    private List<Laborator> laboratoare;
    private List<Programare> programari;


    public Spital(String nume, String adresa, List<Sectie> sectii, List<Laborator> laboratoare, List<Programare> programari) {
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

    public List<Sectie> getSectii() {
        return sectii;
    }

    public void setSectii(List<Sectie> sectii) {
        this.sectii = sectii;
    }

    public List<Laborator> getLaboratoare() {
        return laboratoare;
    }

    public void setLaboratoare(List<Laborator> laboratoare) {
        this.laboratoare = laboratoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Programare> getProgramari() {
        return programari;
    }

    public void setProgramari(List<Programare> programari) {
        this.programari = programari;
    }
}
