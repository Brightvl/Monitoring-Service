package view.menu.commands;

import lombok.AllArgsConstructor;
import view.ConsoleUI;

/**
 * Команда для регистрации
 */
@AllArgsConstructor
public class SignUp implements Command {
    private final ConsoleUI consoleUI;

    @Override
    public String getDescription() {
        return "Зарегистрироваться";
    }

    @Override
    public void execute() {
        consoleUI.registerUser();
    }
}
