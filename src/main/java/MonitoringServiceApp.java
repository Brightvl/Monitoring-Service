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
/*
todo 4. Отсутствуют тесты
todo 7. Не реализован аудит действий пользователя. Аудит это не лог
todo 11. Не реализован функционал администратора
 */