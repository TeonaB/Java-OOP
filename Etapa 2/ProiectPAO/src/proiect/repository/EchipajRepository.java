package proiect.repository;

import proiect.config.DatabaseConfiguration;
import proiect.domain.Echipaj;
import proiect.service.AuditService;

import java.sql.*;

public class EchipajRepository {

    public void createEchipaj(String nume, String rol_echipaj, Date data) throws SQLException {
        String query = "INSERT INTO Echipaj (nume, rol_echipaj, data_infiintare) VALUES (?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, rol_echipaj);
            statement.setDate(3, data);
            statement.executeUpdate();
            System.out.println("Echipaj inserted successfully.");
            AuditService.logAction("CreateEchipaj");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Echipaj getEchipaj(int id){
        String query = "SELECT * FROM Echipaj WHERE id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try(PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                String nume = resultSet.getString("nume");
                String rol_echipaj = resultSet.getString("rol_echipaj");
                Date data = resultSet.getDate("data_infiintare");
                Echipaj echipaj = new Echipaj(nume, rol_echipaj,data);
                AuditService.logAction("GetEchipaj");
                return echipaj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllEchipaj(){
        String query = "select * from Echipaj";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String rol_echipaj = resultSet.getString("rol_echipaj");
                Date data = resultSet.getDate("data_infiintare");

                System.out.println("Nume: " + nume);
                System.out.println("Rol Echipaj: " + rol_echipaj);
                System.out.println("Data de infiintare" + data);

                System.out.println();
            }
            AuditService.logAction("GetAllEchipaj");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEchipaj(int id, String nume, String rol_echipaj, Date data){
        String query = "UPDATE Echipaj SET nume = ?, rol_echipaj = ? , data_infiintare = ? WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.setString(2, rol_echipaj);
            statement.setDate(3,data);
            statement.setInt(4,id);
            statement.executeUpdate();
            System.out.println("Echipaj updated successfully.");
            AuditService.logAction("UpdateEchipaj");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEchipaj(int id) {
        String query = "DELETE FROM Echipaj WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Echipaj deleted successfully.");
            AuditService.logAction("DeleteEchipaj");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
