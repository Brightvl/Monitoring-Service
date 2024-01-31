package view.interactionConsole;

import java.util.Scanner;

/**
 * Класс для удобного ввода и вывода в консоль
 */
public class ConsoleReader implements Output, Input {

    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Проверяет веденные пользователем данные, являются ли они целыми числами
     *
     * @param line входная строка
     * @return boolean
     */
    public boolean checkLineOnNumbers(String line) {
        return line.matches("[0-9]+");
    }

    public Integer nextInt() {
        return scanner.nextInt();
    }

    public String next() {
        return scanner.next();
    }

    /**
     * Ввод для пользователя с сообщением с переносом
     *
     * @param message сообщение
     * @return число
     */
    public Integer inputNextInt(String message) {
        System.out.print(message);
        return nextInt();
    }

    /**
     * Ввод для пользователя с сообщением в одну строку
     *
     * @param message сообщение
     * @return строка
     */
    public String input(String message) {
        System.out.print(message);
        return next();
    }


    public void println(String message) {
        System.out.println(message);
    }
}
