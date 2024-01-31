package view.menu.commands;

import view.ConsoleUI;

/**
 * Команда для регистрации
 */
public class SignUp implements Command {
    private final ConsoleUI consoleUI;

    public SignUp(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Зарегистрироваться";
    }

    @Override
    public void execute() {
        consoleUI.registerUser();
    }
}
