package proiecteap.clase;
import java.util.List;

public class Laborator extends Post{
    private List<String> echipament;


    public Laborator(String nume, List<String> specAngajati, List<Doctor> doctori, List<Angajat> angajati, List<String> echipament) {
        super(nume, specAngajati, doctori, angajati);
        this.echipament = echipament;
    }

    public List<String> getEchipament() {
        return echipament;
    }

    public void setEchipament(List<String> echipament) {
        this.echipament = echipament;
    }
}
