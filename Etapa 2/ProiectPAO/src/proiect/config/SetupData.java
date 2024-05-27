package proiect.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupData {

    public void createTable() {
        String[] createTableSql = {
                """
                CREATE TABLE IF NOT EXISTS Job(
                id INTEGER PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50) NOT NULL,
                tip_contract VARCHAR(50) NOT NULL
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS Departament(
                id INTEGER PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50) NOT NULL,
                buget_anual INT NOT NULL
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS Echipaj(
                id INTEGER PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50) NOT NULL,
                rol_echipaj VARCHAR(50) NOT NULL,
                data_infiintare DATE NOT NULL
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS Angajat(
                id INTEGER PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50) NOT NULL,
                prenume VARCHAR(50) NOT NULL,
                varsta INT NOT NULL,
                data_angajare DATE NOT NULL,
                salariu INT NOT NULL,
                job_id INT NOT NULL,
                departament_id INT NOT NULL,
                echipaj_id INT NOT NULL,
                FOREIGN KEY (job_id) REFERENCES Job(id),
                FOREIGN KEY (departament_id) REFERENCES Departament(id),
                FOREIGN KEY (echipaj_id) REFERENCES Echipaj(id)
                )
                """
        };

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            for (String sql : createTableSql) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}