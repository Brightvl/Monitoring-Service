package view.menu.commands;

import view.ConsoleUI;

/**
 * Закрытие программы
 */
public class CloseProgram implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект CloseProgram.
     * @param consoleUI объект ConsoleUI, используемый для завершения программы с сохранением
     */
    public CloseProgram(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
