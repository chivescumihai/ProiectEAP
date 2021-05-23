package proiecteap.database.repositories;
import proiecteap.clase.Doctor;
import proiecteap.database.DbAuditService;
import proiecteap.servicii.Validare;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DoctorRepository {

    Validare validare = new Validare();
    DbAuditService dbAuditService = new DbAuditService();
    public void insertDoctor(Doctor d) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("insertDoctor ("+d.getID()+", "+d.getNume()+", "+d.getSpecializare()+", "+d.getVarsta()+"ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "INSERT INTO DOCTORI(id, nume, specializare, varsta) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (validare.validDoctor(d) == true) {
                preparedStatement.setInt(1, d.getID());
                preparedStatement.setString(2, d.getNume());
                preparedStatement.setString(3, d.getSpecializare());
                preparedStatement.setInt(4, d.getVarsta());

                preparedStatement.execute();
            }
            else {
                validare.validDoctor(d);
            }

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("Eroare la adaugarea doctorului "+ d.getNume());
        }
    }

    public List<Doctor> selectDoctori() throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("selectDoctori()");

        List<Doctor> doctori = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "SELECT * FROM DOCTORI";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while(!resultSet.isClosed() && resultSet.next()) {

                String nume, spec;
                int id, varsta;
                id = resultSet.getInt("id");
                nume = resultSet.getString("nume");
                spec = resultSet.getString("specializare");
                varsta = resultSet.getInt("varsta");
                Doctor doctor = new Doctor(nume, spec, varsta);
                doctor.setID(id);
                doctori.add(doctor);
            }

            connection.close();
            return doctori;

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException(throwables);
        }
    }

    public void deleteDoctor(Doctor d) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("deleteDoctor ("+d.getID()+", "+d.getNume()+", "+d.getSpecializare()+", "+d.getVarsta()+"ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "DELETE FROM DOCTORI WHERE id like ? and nume like ? and specializare like ? and varsta like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int id, varsta;
            String nume, spec, any = "%";
            id = d.getID();
            nume = d.getNume();
            spec = d.getSpecializare();
            varsta = d.getVarsta();

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

            if (spec == null)
            {
                preparedStatement.setString(3, any);

            }
            else
            {
                preparedStatement.setString(3, spec);
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

    public void updateDoctor(Doctor dv, Doctor dn) throws IOException {
        String urlDB = "jdbc:mysql://localhost:3306/proiecteap_spital";
        String username = "Mihai";
        String pass = "1234567890";
        dbAuditService.scrie("updateDoctor ("+dv.getID()+", "+dv.getNume()+", "+dv.getSpecializare()+", "+dv.getVarsta()+" ani)  -->  ("+dn.getID()+", "+dn.getNume()+", "+dn.getSpecializare()+", "+dn.getVarsta()+" ani)");
        try
        {
            Connection connection = DriverManager.getConnection(urlDB, username, pass);
            String query = "UPDATE DOCTORI SET id = ?, nume = ?, specializare = ?, varsta = ? WHERE id like ? and nume like ? and specializare like ? and varsta like ?;";
            String any = "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (validare.validDoctor(dn) == true) {
                int idn = dn.getID(), idv = dv.getID();
                String numen = dn.getNume(), numev = dv.getNume();
                String specn = dn.getSpecializare(), specv = dv.getSpecializare();
                int varstan = dn.getVarsta(), varstav = dv.getVarsta();
                preparedStatement.setInt(1, idn);
                preparedStatement.setString(2, numen);
                preparedStatement.setString(3, specn);
                preparedStatement.setInt(4, varstan);

                if(dv.getID() == 0)
                {
                    preparedStatement.setString(5, any);
                }
                else {
                    preparedStatement.setInt(5, idv);
                }
                if(dv.getNume() == null)
                {
                    preparedStatement.setString(6, any);
                }
                else {
                    preparedStatement.setString(6, numev);
                }
                if(dv.getSpecializare() == null){
                    preparedStatement.setString(7, any);
                }
                else {
                    preparedStatement.setString(7, specv);
                }
                if (dv.getVarsta() == 0) {
                    preparedStatement.setString(8, any);
                }
                else {
                    preparedStatement.setInt(8, varstav);
                }

                preparedStatement.execute();
            }
            else {
                validare.validDoctor(dn);
            }

            connection.close();

        }
        catch (SQLException throwables) {
            System.out.println(throwables);
            throw new RuntimeException("Eroare la modificarea doctorului "+ dn.getNume());
        }
    }

}
