package proiecteap.clase;

public class Programare {
    private static int nr;
    private int ID;
    private Pacient pacient;
    private Date data;
    private Sectie sectie;
    private Doctor doctor;


    public Programare(Pacient pacient, Date data, Sectie sectie, Doctor doctor) {
        this.ID = ++nr;
        this.pacient = pacient;
        this.data = data;
        this.sectie = sectie;
        this.doctor = doctor;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Sectie getSectie() {
        return this.sectie;
    }

    public void setSectie(Sectie sectie) {
        this.sectie = sectie;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getID() {
        return this.ID;
    }
}
