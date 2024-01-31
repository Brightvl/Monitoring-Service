package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для выбора показания по месяцу
 */
@AllArgsConstructor
public class ViewReadingsForMonth implements Command {
    private final String userName;
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Показать показание за месяц";
    }

    @Override
    public void execute() {
        consoleUI.viewReadingsForMonth(userName);
    }
}
