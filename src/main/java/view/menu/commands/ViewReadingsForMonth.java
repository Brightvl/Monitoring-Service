package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для выбора показания по месяцу
 */
public class ViewReadingsForMonth implements Command {
    private ConsoleUI consoleUI;
    private String userName;

    public ViewReadingsForMonth(String userName, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.userName = userName;
    }

    @Override
    public String getDescription() {
        return "Показать показание за месяц";
    }

    @Override
    public void execute() {
        consoleUI.viewReadingsForMonth(userName);
    }
}
