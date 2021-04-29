package proiecteap.servicii;
import proiecteap.clase.Doctor;
import proiecteap.clase.Doctor;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DoctorService {
    Service service = new Service();
    private static DoctorService doctorService = new DoctorService();

    private DoctorService() {
    }

    ;

    public static DoctorService getInstance() {
        return doctorService;
    }

    public List<Doctor> citireDoctori (String filepath) {
        ArrayList<Doctor> d = new ArrayList<Doctor>();
        int i = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = "";
            String delimiter = ",";

            while((line = br.readLine()) != null)
            {
                StringTokenizer stringTokenizer = new StringTokenizer(line, delimiter);
                while (stringTokenizer.hasMoreTokens()) {
                    String nume, specializare;
                    int varsta;
                    nume = stringTokenizer.nextToken();
                    specializare = stringTokenizer.nextToken();
                    varsta = Integer.parseInt(stringTokenizer.nextToken());

                    Doctor aux = new Doctor(nume, specializare, varsta);
                    d.add(aux);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return d;
    }

    public void afisareDoctori (List<Doctor> doctori) {
        File file = new File("E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\Fisiere CSV\\doctorout.csv");

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Doctor d: doctori)
            {
                pw.append("ID: "+d.getID()+"\n");
                pw.append("Nume :"+d.getNume()+"\n");
                pw.append("Specializare :"+d.getSpecializare()+"\n");
                pw.append("Varsta : "+d.getVarsta()+"\n\n");
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
