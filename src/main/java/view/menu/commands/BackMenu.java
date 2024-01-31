package view.menu.commands;

import view.ConsoleUI;

/**
 * Для возврата из меню пользователя
 */
public class BackMenu implements Command {
    private  ConsoleUI consoleUI;

    public BackMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вернуться назад";
    }

    @Override
    public void execute() {
        consoleUI.exitUserMenu();

    }
}
