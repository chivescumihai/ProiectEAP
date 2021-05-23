package proiecteap.database.repositories;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import proiecteap.clase.Pacient;
import proiecteap.database.DbAuditService;
import proiecteap.servicii.Validare;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientRepository {

    Validare validare = new Validare();
    DbAuditService dbAuditService = new DbAuditService();

    public void insertPacient(Pacient p) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("insertPacient ("+p.getID()+", "+p.getNume()+", "+p.getVarsta()+"ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String queryAfectiuni = "INSERT INTO AFECTIUNI(nume) VALUES (?)";
            PreparedStatement preparedStatementAfectiuni = connection.prepareStatement(queryAfectiuni, Statement.RETURN_GENERATED_KEYS);
            for (String af:p.getAfectiuni()) {
                preparedStatementAfectiuni.setString(1, af);
                preparedStatementAfectiuni.execute();
            }


            String query = "INSERT INTO PACIENTI(id, nume, varsta) VALUES(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (validare.validPacient(p) == true) {
                preparedStatement.setInt(1, p.getID());
                preparedStatement.setString(2, p.getNume());
                preparedStatement.setInt(3, p.getVarsta());

                preparedStatement.execute();
            }
            else {
                validare.validPacient(p);
            }

            String queryInter = "INSERT INTO inter_afectiuni_pacienti(id_pacient, nume_afectiune) VALUES(?, ?);";
            PreparedStatement preparedStatementInter = connection.prepareStatement(queryInter, Statement.RETURN_GENERATED_KEYS);
            for (String af:p.getAfectiuni()) {
                preparedStatementInter.setInt(1, p.getID());
                preparedStatementInter.setString(2, af);
                preparedStatementInter.execute();
            }

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("Eroare la adaugarea pacientului "+ p.getNume());
        }
    }

    public List<Pacient> selectPacienti() throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("selectPacienti()");

        List<Pacient> pacienti = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "SELECT * FROM PACIENTI";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while(!resultSet.isClosed() && resultSet.next()) {

                String nume;
                int id, varsta;
                id = resultSet.getInt("id");
                nume = resultSet.getString("nume");
                varsta = resultSet.getInt("varsta");
                List<String> af = new ArrayList<>();

                String query2 = "SELECT nume_afectiune FROM inter_afectiuni_pacienti WHERE id_pacient LIKE "+Integer.toString(id)+";";
                Statement statement = connection.createStatement();
                ResultSet resultSet2 = statement.executeQuery(query2);

                while (!resultSet2.isClosed() && resultSet2.next())
                {
                    af.add(resultSet2.getString("nume_afectiune"));
                }

                Pacient pacient = new Pacient(nume, varsta, af);
                pacient.setID(id);
                pacienti.add(pacient);
            }

            connection.close();
            return pacienti;

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void deletePacient(Pacient p) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("deletePacient ("+p.getID()+", "+p.getNume()+", "+p.getVarsta()+"ani)");
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "DELETE FROM PACIENTI WHERE id like ? and nume like ? and varsta like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int id, varsta;
            String nume, any = "%";
            id = p.getID();
            nume = p.getNume();
            varsta = p.getVarsta();

            if (id != 0) {
                preparedStatement.setInt(1, id);
            } else {
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
            if (varsta != 0)
            {
                preparedStatement.setInt(3, varsta);
            }
            else
            {
                preparedStatement.setString(3, any);
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
