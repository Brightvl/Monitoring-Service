package view;

import model.data.Month;
import model.meter.MeterReading;
import presenter.Presenter;
import view.interactionConsole.ConsoleReader;
import view.menu.Menu;
import view.menu.typesMenu.MainMenu;
import view.menu.typesMenu.UserMenu;

import java.util.InputMismatchException;

/**
 * Консольное отображение
 */
public class ConsoleUI implements View {

    /**
     * Презентер приложения
     */
    private final Presenter presenter;
    /**
     * Меню программы
     */
    private Menu menu;
    private final ConsoleReader cReader;

    /**
     * Конструктор класса
     */
    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.cReader = new ConsoleReader();
    }

    /**
     * Запуск отображения
     */
    @Override
    public void run() {
        showMenu();
    }

    /**
     * Отображение меню
     */
    private void showMenu() {
        menu = new MainMenu(this);
        while (menu.isRunning()) {
            cReader.println(menu.printMenu());
            String choice = cReader.input("Выберите пункт меню: ");
            if (menu.checkInputLineMenu(choice) == -1) {
                cReader.println("Ошибка ввода");
                continue;
            }
            menu.execute(Integer.parseInt(choice));
        }
    }

    /**
     * Регистрация пользователя
     */
    public void registerUser() {
        String username = cReader.input("Введите имя: ");

        if (presenter.checkUserExistence(username)) {
            System.out.println("Пользователь уже существует. Пожалуйста, выберите другое имя пользователя.");
        } else {
            String password = cReader.input("Введите пароль: ");
            if (presenter.registerUser(username, password)) {
                System.out.println("Пользователь успешно зарегистрирован.");
            } else {
                System.out.println("Регистрация прервана по непонятным причинам");
            }
        }
    }

    /**
     * Залогиниться
     */
    public void loginUser() {
        String username = cReader.input("Введите имя пользователя: ");
        String password = cReader.input("Введите пароль: ");
        if (presenter.checkUserExistence(username)
                && presenter.tryVerification(username, password)) {
            System.out.println("Авторизация успешна.");
            presenter.addTempUser(username);
            // Выполнение действий
            showClientMenu(username);
        } else {
            System.out.println("Неверные учетные данные. Пожалуйста, попробуйте еще раз.");
        }
    }

    /**
     * Пользовательское меню
     */
    private void showClientMenu(String username) {
        this.menu = new UserMenu(username, this);
        while (menu.isRunning()) {
            cReader.println(menu.printMenu());
            String choice = cReader.input("Выберите пункт меню: ");
            if (menu.checkInputLineMenu(choice) == -1) {
                cReader.println("Ошибка ввода");
                continue;
            }
            menu.execute(Integer.parseInt(choice));
        }
    }


    /**
     * Добавить показания счетчика
     *
     * @param username имя
     */
    public void submitMeterReading(String username) {
        String month = cReader.input("Введите месяц: ");
        if (Month.checkMonth(month)) {
            if (presenter.checkUserExistence(username) && presenter.checkMonthLatestReading(month)) {
                System.out.println("Показания счетчиков за этот месяц уже поданы. Редактирование запрещено.");
            } else {
                try {
                    int heating = cReader.inputNextInt("Введите показания нагрева: ");
                    int hotWater = cReader.inputNextInt("Введите показания горячей воды: ");
                    int coldWater = cReader.inputNextInt("Введите показания холодной воды: ");

                    if (presenter.addMeterReadings(new MeterReading(month, heating, hotWater, coldWater))) {
                        System.out.println("Показания счетчика успешно отправлены.");
                    } else {
                        System.out.println("Произошла ошибка");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Пожалуйста, введите целые числа.");
                    cReader.next();
                }
            }
        } else {
            System.out.println("Неизвестный месяц " + month);
        }
    }

    /**
     * Отобразить последнее добавленное показание
     *
     * @param username имя пользователя
     */
    public void viewLatestReading(String username) {
        if (presenter.checkLatestReading(username)) {
            System.out.println(presenter.showLatestReading(username));
        } else {
            System.out.println("Для пользователя нет доступных показаний.");
        }
    }

    /**
     * Показать историю сообщений
     *
     * @param username имя пользователя
     */
    public void viewReadingHistory(String username) {
        if (presenter.checkMeterHistory()) {
            System.out.println("Для пользователя нет истории чтения.");
        } else {
            System.out.println("Чтение истории:");
            System.out.println(presenter.showMeterHistory());
        }
    }

    /**
     * Просмотр показаний за конкретный месяц
     *
     * @param username имя пользователя
     */
    public void viewReadingsForMonth(String username) {
        if (!presenter.checkMeterHistory()) {
            String month = cReader.input("Введите месяц: ");
            if (Month.checkMonth(month)) {
                if (presenter.checkUserExistence(username)) {
                    System.out.println(presenter.showReadingsForMonth(username, month));
                } else {
                    System.out.println("Неизвестный пользователь");
                }
            } else {
                System.out.println("Неизвестный месяц");
            }
        } else {
            System.out.println("История показаний пуста");
        }

    }

    /**
     * Выход из меню пользователя
     */
    public void exitUserMenu() {
        System.out.println("Выход из системы...");
        presenter.exitUser();
        showMenu();
    }
}
