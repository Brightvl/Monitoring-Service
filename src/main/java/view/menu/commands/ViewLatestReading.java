package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для отображения последнего изменения
 */
public class ViewLatestReading implements Command {
    private ConsoleUI consoleUI;
    private String userName;

    public ViewLatestReading(String userName, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.userName = userName;
    }

    @Override
    public String getDescription() {
        return "Показать последнее показание";
    }

    @Override
    public void execute() {
        consoleUI.viewLatestReading(userName);
    }
}
