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
todo 1. Нет pull request, комментировать код негде
todo 3. .idea/ в репозитории быть не должно
todo 4. Отсутствуют тесты
todo 6. Не предусмотрено расширение перечня подаваемых показаний
todo 7. Не реализован аудит действий пользователя. Аудит это не лог
todo 8. Подумай над именами классов: из имени не ясно что делает LocalRepository
todo 9. Метод getUsers класса LocalRepository возвращает изменяемый список пользователей. Значит его может изменить кто-то из вне, так быть не должно
todo 11. Не реализован функционал администратора
 */