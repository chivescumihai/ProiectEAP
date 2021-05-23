package proiecteap.database.repositories;

import proiecteap.clase.Angajat;
import proiecteap.database.DbAuditService;
import proiecteap.servicii.Validare;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AngajatRepository {

    Validare validare = new Validare();
    DbAuditService dbAuditService = new DbAuditService();

    public void insertAngajat(Angajat a) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("insertAngajat ("+a.getID()+", "+a.getNume()+", "+a.getTitlu()+", "+a.getVarsta()+"ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "INSERT INTO ANGAJATI(id, nume, titlu, varsta) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (validare.validAngajat(a) == true) {
                preparedStatement.setInt(1, a.getID());
                preparedStatement.setString(2, a.getNume());
                preparedStatement.setString(3, a.getTitlu());
                preparedStatement.setInt(4, a.getVarsta());

                preparedStatement.execute();
            }
            else {
                validare.validAngajat(a);
            }

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("Eroare la adaugarea angajatului "+ a.getNume());
        }
    }

    public List<Angajat> selectAngajati() throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("selectAngajati()");

        List<Angajat> angajati = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "SELECT * FROM ANGAJATI";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while(!resultSet.isClosed() && resultSet.next()) {

                String nume, titlu;
                int id, varsta;
                id = resultSet.getInt("id");
                nume = resultSet.getString("nume");
                titlu = resultSet.getString("titlu");
                varsta = resultSet.getInt("varsta");
                Angajat angajat = new Angajat(nume, titlu, varsta);
                angajat.setID(id);
                angajati.add(angajat);
            }

            connection.close();
            return angajati;

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void deleteAngajat(Angajat a) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("deleteAngajat ("+a.getID()+", "+a.getNume()+", "+a.getTitlu()+", "+a.getVarsta()+"ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "DELETE FROM ANGAJATI WHERE id like ? and nume like ? and titlu like ? and varsta like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int id, varsta;
            String nume, titlu, any = "%";
            id = a.getID();
            nume = a.getNume();
            titlu = a.getTitlu();
            varsta = a.getVarsta();

            if (id != 0) {
                preparedStatement.setInt(1, id);
            }
            else
            {
                preparedStatement.setString(1, any);
            }

            if (nume == null)
            {
                preparedStatement.setString(2, any);

            }
            else
            {
                preparedStatement.setString(2, nume);
            }

            if (titlu == null)
            {
                preparedStatement.setString(3, any);

            }
            else
            {
                preparedStatement.setString(3, titlu);
            }

            if (varsta != 0)
            {
                preparedStatement.setInt(4, varsta);
            }
            else
            {
                preparedStatement.setString(4, any);
            }

            preparedStatement.execute();

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void updateAngajat(Angajat av, Angajat an) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("updateAngajat ("+av.getID()+", "+av.getNume()+", "+av.getTitlu()+", "+av.getVarsta()+" ani)  -->  ("+an.getID()+", "+an.getNume()+", "+an.getTitlu()+", "+an.getVarsta()+" ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "UPDATE ANGAJATI SET id = ?, nume = ?, titlu = ?, varsta = ? WHERE id like ? and nume like ? and titlu like ? and varsta like ?;";
            String any = "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (validare.validAngajat(an) == true) {
                int idn = an.getID(), idv = av.getID();
                String numen = an.getNume(), numev = av.getNume();
                String titn = an.getTitlu(), titv = av.getTitlu();
                int varstan = an.getVarsta(), varstav = av.getVarsta();
                preparedStatement.setInt(1, idn);
                preparedStatement.setString(2, numen);
                preparedStatement.setString(3, titn);
                preparedStatement.setInt(4, varstan);

                if(av.getID() == 0)
                {
                    preparedStatement.setString(5, any);
                }
                else {
                    preparedStatement.setInt(5, idv);
                }
                if(av.getNume() == null)
                {
                    preparedStatement.setString(6, any);
                }
                else {
                    preparedStatement.setString(6, numev);
                }
                if(av.getTitlu() == null){
                    preparedStatement.setString(7, any);
                }
                else {
                    preparedStatement.setString(7, titv);
                }
                if (av.getVarsta() == 0) {
                    preparedStatement.setString(8, any);
                }
                else {
                    preparedStatement.setInt(8, varstav);
                }

                preparedStatement.execute();
            }
            else {
                validare.validAngajat(an);
            }

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("Eroare la modificarea angajatului "+ an.getNume());
        }
    }
}
