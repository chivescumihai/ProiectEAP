package proiecteap.database.repositories;

import proiecteap.clase.Doctor;
import proiecteap.database.DbAuditService;
import proiecteap.servicii.Validare;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AfectiuniRepository {
    Validare validare = new Validare();
    DbAuditService dbAuditService = new DbAuditService();

    public void insertAfectiune (String afectiune) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("insertAfectiune ("+afectiune+")");
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "INSERT INTO AFECTIUNI (nume) VALUES(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (afectiune != null)
            {
                preparedStatement.setString(1, afectiune);
            }
            else {
                System.out.println("Introduceti un nume pentru afectiune");
            }

            preparedStatement.execute();

            connection.close();


        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public List<String> selectAfectiuni() throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("selectAfectiuni()");

        List<String> afectiuni = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "SELECT * FROM AFECTIUNI";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while(!resultSet.isClosed() && resultSet.next()) {

                String nume;
                nume = resultSet.getString("nume");

                afectiuni.add(nume);
            }

            connection.close();
            return afectiuni;

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void deleteAfectiune(String a) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("deleteAfectiune ("+a+")");
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "DELETE FROM AFECTIUNI WHERE nume LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            if (a == null) {
                System.out.println("Introduceti numele unei afectiuni!");
            } else {
                preparedStatement.setString(1, a);
            }

            preparedStatement.execute();

            connection.close();
        } catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void updateAfectiune(String av, String an) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("updateAfectiune ("+av+") -->  ("+an+")");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "UPDATE AFECTIUNI SET nume = ? WHERE nume LIKE ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (an == null) {
                System.out.println("Introduceti un nume pentru afectiunea noua");
            }
            else if (av == null) {
                System.out.println("Introduceti numele afectiunii cautate");
            }
            else {
                preparedStatement.setString(1, an);
                preparedStatement.setString(2, av);
            }

            preparedStatement.execute();

            connection.close();
        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }
}
