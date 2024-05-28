package proiect.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proiect.config.DatabaseConfiguration;
import proiect.domain.Job;
import proiect.service.AuditService;

public class JobRepository {

    public void createJob(String nume, String tip_contract) throws SQLException {
        String query = "INSERT INTO Job (nume, tip_contract) VALUES (?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, tip_contract);
            statement.executeUpdate();
            System.out.println("Job inserted successfully.");
            AuditService.logAction("CreateJob");
            }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Job getJob(int id){
        String query = "SELECT * FROM Job WHERE id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try(PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                String nume = resultSet.getString("nume");
                String contract = resultSet.getString("tip_contract");
                Job job = new Job(nume, contract);
                AuditService.logAction("GetJob");
                return job;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllJobs(){
        String query = "select * from Job";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String tip_contract = resultSet.getString("tip_contract");

                System.out.println("Nume: " + nume);
                System.out.println("Contract: " + tip_contract);

                System.out.println();
            }
            AuditService.logAction("GetAllJob");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJob(int id, String nume, String tip_contract){
        String query = "UPDATE Job SET nume = ?, tip_contract = ? WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, tip_contract);
            statement.setInt(3,id);
            statement.executeUpdate();
            System.out.println("Job updated successfully.");
            AuditService.logAction("UpdateJob");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJob(int id) {
        String query = "DELETE FROM Job WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Job deleted successfully.");
            AuditService.logAction("DeleteJob");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

