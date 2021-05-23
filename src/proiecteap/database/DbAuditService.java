package proiecteap.database;

import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;

public class DbAuditService {
    public void scrie(String string) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File file = new File("E:\\Fac\\Anul II\\Sem II\\Elemente Avansate de Programare\\Proiect\\src\\proiecteap\\database\\DbAudit.csv");

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.append(string+"   "+timestamp+"\n");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
