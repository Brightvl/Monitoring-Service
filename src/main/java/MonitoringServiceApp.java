import model.db.DatabaseConnection;
import view.ConsoleUI;
import view.View;

import java.sql.SQLException;

/**
 * Класс для запуска консольного приложения
 */
public class MonitoringServiceApp {
    public static void main(String[] args) {

        DatabaseConnection.getConnection();
        View consoleUI = new ConsoleUI();
        consoleUI.run();
    }
}

