package view;

import model.data.Month;
import model.log.AuditLog;
import model.meter.MeterReading;
import presenter.Presenter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View {
    // свойства
    private Presenter presenter;


    public ConsoleUI() {
        this.presenter = new Presenter(this);
    }

    @Override
    public void run() {
        showMenu();
    }

    /**
     * Отображение меню
     */
    private void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Зарегистрироваться\n2. Войти\n3. Выход");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    registerUser(scanner);
                    break;
                case "2":
                    loginUser(scanner);
                    break;
                case "3":
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    /**
     * Регистрация пользователя
     *
     * @param scanner
     */
    private void registerUser(Scanner scanner) {
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
     *
     * @param scanner
     */
    private void loginUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.next();

        System.out.print("Введите пароль: ");
        String password = scanner.next();

        if (presenter.checkUserExistence(username) && presenter.tryVerification(username, password)) {
            System.out.println("Авторизация успешна.");
            presenter.addTempUser(username);
            // Выполнение действий
            showUserMenu(username, scanner);
        } else {
            System.out.println("Неверные учетные данные. Пожалуйста, попробуйте еще раз.");
        }

    }

    /**
     * Пользовательское меню
     *
     * @param username Имя пользователя
     * @param scanner
     */
    private void showUserMenu(String username, Scanner scanner) {
        while (true) {
            System.out.println("1. Отправьте показания счетчика\n" +
                    "2. Просмотр последнего поданного показания\n" +
                    "3. Просмотр истории подачи показаний\n" +
                    "4. Выйти");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    submitMeterReading(username, scanner);
                    break;
                case "2":
                    viewLatestReading(username);
                    break;
                case "3":
                    viewReadingHistory(username);
                    break;
                case "4":
                    exitUserMenu(username);
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    /**
     * Выход из меню пользователя
     *
     * @param username
     */
    private void exitUserMenu(String username) {
        System.out.println("Выход из системы...");
        AuditLog.log("Выйти", username);
        presenter.exitUser();
    }

    /**
     * Добавить показания счетчика
     *
     * @param username имя
     * @param scanner
     */
    private void submitMeterReading(String username, Scanner scanner) {
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
            System.out.println("Неизвестный месяц "+ month);
        }
    }


    /**
     * Отобразить последнее добавление показаний
     *
     * @param username
     */
    private void viewLatestReading(String username) {
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
    private void viewReadingHistory(String username) {
        if (presenter.checkMeterHistory()) {
            System.out.println("Для пользователя нет истории чтения.");
        } else {
            System.out.println("Чтение истории:");
            System.out.println(presenter.showMeterHistory());
        }
    }


}
