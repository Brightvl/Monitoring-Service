package view;

import model.data.Month;
import model.meter.MeterReading;
import presenter.Presenter;
import view.interactionConsole.ConsoleReader;
import view.menu.Menu;
import view.menu.typesMenu.MainMenu;
import view.menu.typesMenu.UserMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Консольное отображение
 */
public class ConsoleUI implements View {

    /**
     * Прзентер приложения
     */
    private Presenter presenter;

    private Menu menu;

    private Scanner scanner;
    private ConsoleReader consoleReader;

    /**
     * Конструктор класса
     */
    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.scanner = new Scanner(System.in);
        this.consoleReader = new ConsoleReader();
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
            consoleReader.println(menu.printMenu());
            String choice = consoleReader.input("Выберите пункт меню: ");
            if (menu.checkInputLineMenu(choice) == -1) {
                consoleReader.println("Ошибка ввода");
                continue;
            }
            menu.execute(Integer.parseInt(choice));
        }
    }

    /**
     * Регистрация пользователя
     */
    public void registerUser() {
        System.out.print("Введите имя: ");
        String username = scanner.next();

        if (presenter.checkUserExistence(username)) {
            System.out.println("Пользователь уже существует. Пожалуйста, выберите другое имя пользователя.");
        } else {
            System.out.print("Введите пароль: ");
            String password = scanner.next();
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
        System.out.print("Введите имя пользователя: ");
        String username = scanner.next();

        System.out.print("Введите пароль: ");
        String password = scanner.next();

        if (presenter.checkUserExistence(username)
                && presenter.tryVerification(username, password)) {
            System.out.println("Авторизация успешна.");
            presenter.addTempUser(username);
            // Выполнение действий
            showUserMenu(username);
        } else {
            System.out.println("Неверные учетные данные. Пожалуйста, попробуйте еще раз.");
        }

    }

    /**
     * Пользовательское меню
     */
    private void showUserMenu(String username) {
        this.menu = new UserMenu(username, this);
        while (menu.isRunning()) {
            consoleReader.println(menu.printMenu());
            String choice = consoleReader.input("Выберите пункт меню: ");
            if (menu.checkInputLineMenu(choice) == -1) {
                consoleReader.println("Ошибка ввода");
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
        System.out.print("Введите месяц: ");
        String month = scanner.next();
        if (Month.checkMonth(month)) {
            if (presenter.checkUserExistence(username) && presenter.checkMonthLatestReading(month)) {
                System.out.println("Показания счетчиков за этот месяц уже поданы. Редактирование запрещено.");
            } else {
                try {
                    System.out.print("Введите показания нагрева: ");
                    int heating = (scanner.nextInt());

                    System.out.print("Введите показания горячей воды: ");
                    int hotWater = scanner.nextInt();

                    System.out.print("Введите показания холодной воды: ");
                    int coldWater = scanner.nextInt();

                    if (presenter.addMeterReadings(new MeterReading(month, heating, hotWater, coldWater))) {
                        System.out.println("Показания счетчика успешно отправлены.");
                    } else {
                        System.out.println("Произошла ошибка");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Пожалуйста, введите целые числа.");
                    scanner.next(); // Очищаем буфер ввода от неверных данных
                }
            }
        } else {
            System.out.println("Неизвестный месяц " + month);
        }
    }


    /**
     * Отобразить последнее добавленное показание
     *
     * @param username
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
     * @param username
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
     * @param username
     */
    public void viewReadingsForMonth(String username) {
        if (!presenter.checkMeterHistory()) {
            System.out.println("Введите месяц: ");
            String month = scanner.next();
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

    public void setPresenter(Presenter mockPresenter) {
        this.presenter = mockPresenter;
    }
}
