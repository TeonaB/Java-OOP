package proiect.repository;

import proiect.config.DatabaseConfiguration;
import proiect.domain.Departament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentRepository {

    public void createDep(String nume, int buget_anual) throws SQLException {
        String query = "INSERT INTO Departament (nume, buget_anual) VALUES (?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setInt(2, buget_anual);
            statement.executeUpdate();
            System.out.println("Departament inserted successfully.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Departament getDep(int id){
        String query = "SELECT * FROM Departament WHERE id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try(PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                String nume = resultSet.getString("nume");
                int buget_anual = resultSet.getInt("buget_anual");
                Departament job = new Departament(nume, buget_anual);
                return job;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllDep(){
        String query = "select * from Departament";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                int buget_anual = resultSet.getInt("buget_anual");

                System.out.println("Nume: " + nume);
                System.out.println("Bugetul anual: " + buget_anual);

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDep(int id, String nume, int buget_anual){
        String query = "UPDATE Departament SET nume = ?, buget_anual = ? WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setInt(2, buget_anual);
            statement.setInt(3,id);
            statement.executeUpdate();
            System.out.println("Departament updated successfully.");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDep(int id) {
        String query = "DELETE FROM Departament WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Departament deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
