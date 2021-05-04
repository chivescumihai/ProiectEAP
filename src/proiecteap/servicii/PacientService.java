package proiecteap.servicii;

import jdk.nashorn.internal.parser.Token;
import proiecteap.clase.Pacient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PacientService {
    Service service = new Service();
    Validare validare = new Validare();

    private static PacientService pacientService = new PacientService();

    private PacientService() {
    }

    ;;

    public static PacientService getInstance() {
        return pacientService;
    }

    public List<Pacient> citirePacienti(String filepath) {
        ArrayList<Pacient> p = new ArrayList<Pacient>();
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = "";
            String delimiter = ",";

            while ((line = br.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, delimiter);
                while (stringTokenizer.hasMoreTokens()) {
                    String nume;
                    List<String> afectiuni = new ArrayList<String>();
                    int varsta;
                    nume = stringTokenizer.nextToken();
                    varsta = Integer.parseInt(stringTokenizer.nextToken());
                    do {
                        afectiuni.add(stringTokenizer.nextToken());
                    } while (stringTokenizer.hasMoreTokens());
                    Pacient aux = new Pacient(nume, varsta, afectiuni);
                    service.addPacient(p, aux);

                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }

    public void afisarePacienti(List<Pacient> pacienti) {
        File file = new File("E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\Fisiere CSV\\pacientout.csv");

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Pacient p : pacienti) {
                pw.append("Nume :" + p.getNume() + "\n");
                pw.append("Varsta : " + p.getVarsta() + "\n");
                pw.append("Afectiuni :" + p.getAfectiuni());
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
