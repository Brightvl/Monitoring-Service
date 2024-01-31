package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для отображения истории показаний
 */
@AllArgsConstructor
public class ViewReadingHistory implements Command {
    private final String userName;
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Показать историю подачи показаний";
    }

    @Override
    public void execute() {
        consoleUI.viewReadingHistory(userName);
    }
}
