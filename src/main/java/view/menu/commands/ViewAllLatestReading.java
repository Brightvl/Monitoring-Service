package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для вывода все последних добавленных показаний
 */
@AllArgsConstructor
public class ViewAllLatestReading implements Command {
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Показать последние показания всех пользователей";
    }

    @Override
    public void execute() {
        consoleUI.showAllLatestReading();
    }
}
