package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для отображения последнего изменения
 */
@AllArgsConstructor
public class ViewLatestReading implements Command {
    private final String userName;
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Показать последнее показание";
    }

    @Override
    public void execute() {
        consoleUI.viewLatestReading(userName);
    }
}
