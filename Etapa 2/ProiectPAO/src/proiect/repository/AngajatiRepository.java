package proiect.repository;

import proiect.config.DatabaseConfiguration;
import proiect.domain.Job;

import java.sql.*;

public class AngajatiRepository {

    public void createAngajat(String nume, String prenum, int varsta, Date data_angajare, int salariu, int job, int dep, int echipaj) throws SQLException {
        String query = "INSERT INTO Angajat (nume, prenume, varsta, data_angajare, salariu, job_id, departament_id , echipaj_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, prenum);
            statement.setInt(3,varsta);
            statement.setDate(4,data_angajare);
            statement.setInt(5,salariu);
            statement.setInt(6,job);
            statement.setInt(7,dep);
            statement.setInt(8,echipaj);
            statement.executeUpdate();
            System.out.println("Angajat inserted successfully.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void getAngajat(int id){
        String query = "SELECT * FROM Angajat WHERE id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try(PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                System.out.println("Nume:" + resultSet.getString("nume"));
                System.out.println("Prenume:" + resultSet.getString("prenume"));
                System.out.println("Varsta:" + resultSet.getInt("varsta"));
                System.out.println("Data de angajare:" + resultSet.getDate("data_angajare"));
                System.out.println("Salariu:" + resultSet.getInt("salariu"));
                System.out.println("Job id:" + resultSet.getInt("job_id"));
                System.out.println("Departament id:" + resultSet.getInt("departament_id"));
                System.out.println("Echipaj id:" + resultSet.getInt("echipaj_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllAngaj(){
        String query = "select * from Angajat";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Nume:" + resultSet.getString("nume"));
                System.out.println("Prenume:" + resultSet.getString("prenume"));
                System.out.println("Varsta:" + resultSet.getInt("varsta"));
                System.out.println("Data de angajare:" + resultSet.getDate("data_angajare"));
                System.out.println("Salariu:" + resultSet.getInt("salariu"));
                System.out.println("Job id:" + resultSet.getInt("job_id"));
                System.out.println("Departament id:" + resultSet.getInt("departament_id"));
                System.out.println("Echipaj id:" + resultSet.getInt("echipaj_id"));

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAngaj(int id, String nume, String prenum, int varsta, Date data_angajare, int salariu, int job, int dep, int echipaj){
        String query = "UPDATE Angajat SET nume = ?, prenume = ?, varsta = ? , data_angajare = ?, salariu = ?, job_id = ?, departament_id = ?, echipaj_id = ? WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, prenum);
            statement.setInt(3,varsta);
            statement.setDate(4,data_angajare);
            statement.setInt(5,salariu);
            statement.setInt(6,job);
            statement.setInt(7,dep);
            statement.setInt(8,echipaj);
            statement.setInt(9,id);
            statement.executeUpdate();

            System.out.println("Anagajat updated successfully.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAngaj(int id) {
        String query = "DELETE FROM Angajat WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Angajat deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
