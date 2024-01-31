package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Для возврата из меню пользователя
 */
@AllArgsConstructor
public class BackMenu implements Command {
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Вернуться назад";
    }

    @Override
    public void execute() {
        consoleUI.exitUserMenu();

    }
}
