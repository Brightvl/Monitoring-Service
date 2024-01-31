package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для добавления показания счетчика
 */
@AllArgsConstructor
public class SubmitMeterReading implements Command {
    private final String userName;
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Отправить показания счетчика";
    }

    @Override
    public void execute() {
        consoleUI.submitMeterReading(userName);
    }
}
