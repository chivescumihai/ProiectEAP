package proiecteap.database;

import java.io.IOException;
import java.net.Socket;

public class DBconnection {

    public void testConn (String host, int port) throws IOException{
        try(Socket client = new Socket(host, port)) {
            boolean connOK = client.isConnected();
            if (connOK == true) {
                System.out.println("Conexiunea la baza de date proiecteap_spital a reusit");
            }
            else
                System.out.println("Conexiunea a esuat");

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
