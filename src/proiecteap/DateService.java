package proiecteap;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;


public class DateService {
    Service service = new Service();
    private static DateService dateService = new DateService();

    private DateService() {
    }

    ;

    public static DateService getInstance() {
        return dateService;
    }

    public List<Date> citireDate (String filepath) {
        ArrayList<Date> d = new ArrayList<Date>();
        int i = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = "";
            String delimiter = ",";
//????????? grupare de cate 6 inturi
            while((line = br.readLine()) != null)
            {
                StringTokenizer stringTokenizer = new StringTokenizer(line, delimiter);
                while (stringTokenizer.hasMoreTokens()) {
                    int an, luna, zi, ora, minut, sec;
                    an = Integer.parseInt(stringTokenizer.nextToken());
                    luna = Integer.parseInt(stringTokenizer.nextToken());
                    zi = Integer.parseInt(stringTokenizer.nextToken());
                    ora = Integer.parseInt(stringTokenizer.nextToken());
                    minut = Integer.parseInt(stringTokenizer.nextToken());
                    sec = Integer.parseInt(stringTokenizer.nextToken());

                    Date aux = new Date(an, luna, zi, ora, minut, sec);
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

    public void afisareDate (List<Date> dates) {
        File file = new File("E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\dateout.csv");

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Date d: dates)
                pw.append(d.getZiua()+"."+d.getLuna()+"."+d.getAn()+"   "+d.getOra()+":"+d.getMinut()+":"+d.getSecunda()+"\n");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

