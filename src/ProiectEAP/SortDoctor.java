package ProiectEAP;
import javax.print.Doc;
import java.util.Comparator;


public class SortDoctor implements Comparator<Doctor>{

    @Override
    public int compare(Doctor d1, Doctor d2) {
        return d1.getNume().compareTo(d2.getNume());
    }
}
