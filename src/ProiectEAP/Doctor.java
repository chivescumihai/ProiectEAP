package ProiectEAP;

public class Doctor implements Persoana {
    private static int nr;
    private int ID;
    private String nume;
    private String specializare;
    private int varsta;



    public Doctor(String nume, String specializare, int varsta) {
        this.ID = ++nr;
        this.nume = nume;
        this.specializare = specializare;
        this.varsta = varsta;
    }


    @Override
    public void setNume(String s) {
        this.nume = nume;
    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public void setVarsta(int v) {
        this.varsta = varsta;
    }

    @Override
    public int getVarsta() {
        return this.varsta;
    }

    int getID(){
        return this.ID;
    }

    void setSpecializare(String spec){
        this.specializare = spec;
    }

    String getSpecializare(){
        return this.specializare;
    }

    void getDetails(){
        System.out.println("Nume doctor : "+this.nume);
        System.out.println("ID Doctor : "+this.ID);
        System.out.println("Varsta doctor : "+this.varsta);
        System.out.println("Specializare doctor : "+this.specializare);
        System.out.println();
    }


}
