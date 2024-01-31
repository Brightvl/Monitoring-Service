package view.menu.commands;

import view.ConsoleUI;

/**
 * Закрытие программы
 */
public class CloseProgram implements Command {

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
