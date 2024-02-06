import model.db.DatabaseConnection;

/**
 * Класс для запуска консольного приложения
 */
public class MonitoringServiceApp {
    public static void main(String[] args) {

//        DatabaseConnection.getConnection();

        DatabaseConnection.getData();
//        View consoleUI = new ConsoleUI();
//        consoleUI.run();
    }
}

