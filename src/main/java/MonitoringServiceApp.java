import view.ConsoleUI;
import view.View;

/**
 * Класс для запуска консольного приложения
 */
public class MonitoringServiceApp {
    public static void main(String[] args) {

        View consoleUI = new ConsoleUI();
        consoleUI.run();
    }
}