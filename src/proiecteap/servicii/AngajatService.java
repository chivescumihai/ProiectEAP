package proiecteap.servicii;

import proiecteap.clase.Angajat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AngajatService {
    Service service = new Service();

    private static AngajatService angajatService = new AngajatService();

    private AngajatService() {
    }

    ;

    public static AngajatService getInstance() {
        return angajatService;
    }

    public List<Angajat> citireAngajati (String filepath) {
        ArrayList<Angajat> a = new ArrayList<Angajat>();
        int i = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = "";
            String delimiter = ",";

            while((line = br.readLine()) != null)
            {
                StringTokenizer stringTokenizer = new StringTokenizer(line, delimiter);
                while (stringTokenizer.hasMoreTokens()) {
                    String nume, titlu;
                    int varsta;
                    nume = stringTokenizer.nextToken();
                    titlu = stringTokenizer.nextToken();
                    varsta = Integer.parseInt(stringTokenizer.nextToken());

                    Angajat aux = new Angajat(nume, titlu, varsta);
                    service.addAngajat(a, aux);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return a;
    }

    public void afisareAngajati (List<Angajat> angajati) {
        File file = new File("E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\Fisiere CSV\\angajatout.csv");

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Angajat d: angajati)
            {
                pw.append("Nume :"+d.getNume()+"\n");
                pw.append("Specializare :"+d.getTitlu()+"\n");
                pw.append("Varsta : "+d.getVarsta()+"\n");
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
