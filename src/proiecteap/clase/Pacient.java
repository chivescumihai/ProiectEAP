package proiecteap.clase;
import java.util.List;

public class Pacient implements Persoana{
    private static int nr;
    private int ID;
    private String nume;
    private int varsta;
    private List<String> afectiuni;

    public Pacient(String nume, int varsta, List<String> afectiuni) {
        this.ID = ++nr;
        this.nume = nume;
        this.varsta = varsta;
        this.afectiuni = afectiuni;
    }


    @Override
    public void setNume(String nume) {
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

    public int getID() {
        return this.ID;
    }

    public List<String> getAfectiuni() {
        return this.afectiuni;
    }

    public void setAfectiuni(List<String> afectiuni) {
        this.afectiuni = afectiuni;
    }

    public void getDetails() {
        System.out.println("ID : "+this.ID);
        System.out.println("Nume : "+this.getNume());
        System.out.println("Varsta : "+this.getVarsta());
        System.out.print("Afectiuni : ");
        for (String s:this.getAfectiuni())
        {
            System.out.print(s+"  ");
        }
        System.out.println();
    }
}
