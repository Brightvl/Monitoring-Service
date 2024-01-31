package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для отображения истории показаний
 */
public class ViewReadingHistory implements Command {
    private ConsoleUI consoleUI;
    private String userName;

    public ViewReadingHistory(String userName, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.userName = userName;
    }

    @Override
    public String getDescription() {
        return "Показать историю подачи показаний";
    }

    @Override
    public void execute() {
        consoleUI.viewReadingHistory(userName);
    }
}
