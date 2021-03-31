package ProiectEAP;
import java.util.Arrays;
import java.util.Comparator;

public class Service {
    public Doctor[] getSortedDoctors (Doctor [] d) {
        Arrays.sort(d, new SortDoctor());
        return d;
    }

    public Pacient [] getSortedPacienti (Pacient [] p) {
        Arrays.sort(p);
        return p;
    }

    public Angajat [] getSortedAngajati (Angajat [] ang) {
        Arrays.sort(ang);
        return ang;
    }

    }
