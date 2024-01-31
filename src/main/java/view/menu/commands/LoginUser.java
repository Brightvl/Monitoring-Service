package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для входа пользователя
 */
@AllArgsConstructor
public class LoginUser implements Command {
    private final ConsoleUI consoleUI;


    @Override
    public String getDescription() {
        return "Войти";
    }

    @Override
    public void execute() {
        consoleUI.loginUser();
    }
}
