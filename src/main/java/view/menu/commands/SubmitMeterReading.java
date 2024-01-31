package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для добавления показания счетчика
 */
public class SubmitMeterReading implements Command {
    private final ConsoleUI consoleUI;
    private final String userName;

    public SubmitMeterReading(String userName, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.userName = userName;
    }

    @Override
    public String getDescription() {
        return "Отправить показания счетчика";
    }

    @Override
    public void execute() {
        consoleUI.submitMeterReading(userName);
    }
}
