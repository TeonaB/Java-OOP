package proiect.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {

    private static final String FILE_PATH = "log_audit.csv";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logAction(String actionName) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);

            String logEntry = "Nume actiune: " + actionName + " , " + timestamp +"\n";
            writer.write(logEntry);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
