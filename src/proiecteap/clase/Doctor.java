package proiecteap.clase;

public class Doctor implements Persoana {
    private static int nr;
    private int ID;
    private String nume;
    private String specializare;
    private int varsta;

    public Doctor(){};

    public Doctor(String nume, String specializare, int varsta) {
        this.ID = ++nr;
        this.nume = nume;
        this.specializare = specializare;
        this.varsta = varsta;
    }


    @Override
    public void setNume(String s) {
        this.nume = s;
    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public void setVarsta(int v) {
        this.varsta = v;
    }

    @Override
    public int getVarsta() {
        return this.varsta;
    }

    public void setID(int nr) {
        this.ID = nr;
    }

    public int getID(){
        return this.ID;
    }

    public void setSpecializare(String spec){
        this.specializare = spec;
    }

    public String getSpecializare(){
        return this.specializare;
    }

    public void getDetails(){
        System.out.println("ID Doctor : "+this.ID);
        System.out.println("Nume doctor : "+this.nume);
        System.out.println("Specializare doctor : "+this.specializare);
        System.out.println("Varsta doctor : "+this.varsta);
        System.out.println();
    }


}
