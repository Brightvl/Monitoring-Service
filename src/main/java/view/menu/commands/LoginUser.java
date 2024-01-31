package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для входа пользователя
 */
public class LoginUser implements Command {
    private ConsoleUI consoleUI;

    public LoginUser(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Войти";
    }

    @Override
    public void execute() {
        consoleUI.loginUser();
    }
}
