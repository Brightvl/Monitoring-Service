package view;

import model.log.AuditLog;
import model.meter.MeterReading;
import presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    // свойства
    private boolean isRun;
    private Presenter presenter;


    public ConsoleUI() {
        this.isRun = true;
        this.presenter = new Presenter();
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
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    /**
     * Регистрация пользователя
     * @param scanner
     */
    private void registerUser(Scanner scanner) {
        System.out.print("Введите имя: ");
        String username = scanner.next();

        if (presenter.checkContainsUser(username)) {
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
     * @param scanner
     */
    private void loginUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.next();

        if (presenter.checkContainsUser(username)) {
            System.out.print("Введите пароль: ");
            String password = scanner.next();
            if (presenter.tryVerification(username, password)) {
                System.out.println("Авторизация успешна.");
                // Выполнение действий
                showUserMenu(username, scanner);
            } else {
                System.out.println("Неверные учетные данные. Пожалуйста, попробуйте еще раз.");
            }
        } else {
            System.out.println("Неверные учетные данные. Пожалуйста, попробуйте еще раз.");
        }
    }


    private void showUserMenu(String username, Scanner scanner) {
        while (true) {
            System.out.println("1. Отправьте показания счетчика\n" +
                    "2. Просмотр последних материалов\n" +
                    "3. Просмотр истории чтения\n" +
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
                    exitUser(username);
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    private void exitUser(String username) {
        System.out.println("Выход из системы...");
        AuditLog.log("Выйти", username);
        presenter.exitUser();
    }

    /**
     * Добавить показания
     * @param username имя
     * @param scanner
     */
    private void submitMeterReading(String username, Scanner scanner) {
        System.out.print("Введите месяц: ");
        String month = scanner.next();
        if (presenter.checkContainsUserInMeter(username)
                && presenter.checkMonthLatestReading(month)) {
            System.out.println("Показания счетчиков за этот месяц уже поданы. Редактирование запрещено.");
        } else {
            System.out.print("Введите показания нагрева: ");
            int heating = scanner.nextInt();

            System.out.print("Введите показания горячей воды: ");
            int hotWater = scanner.nextInt();

            System.out.print("Введите показания холодной воды: ");
            int coldWater = scanner.nextInt();

            // добавляем показания
            AuditLog.log("Отправить показания счетчика", username);
            if (presenter.addMeterReadings(new MeterReading(month, heating, hotWater, coldWater))) {
                System.out.println("Показания счетчика успешно отправлены.");
            } else {
                System.out.println("Произошла ошибка");
            }
        }
    }

    private void viewLatestReading(String username) {
        if (presenter.checkMonthLatestReading(username)) {
            System.out.println(presenter.showLatestReading());
        } else {
            System.out.println("Для пользователя нет доступных показаний.");
        }
    }

    private void viewReadingHistory(String username) {

        if (presenter.checkMeterHistory()) {
            System.out.println("Для пользователя нет истории чтения.");
        } else {
            System.out.println("Чтение истории:");
            System.out.println(presenter.showMeterHistory());
        }
    }
}
