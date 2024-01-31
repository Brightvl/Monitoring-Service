package view.menu.typesMenu;

import view.ConsoleUI;
import view.menu.Menu;
import view.menu.commands.*;

import java.util.ArrayList;

/**
 * MainMenu представляет меню пользователя.
 * Он наследует класс Menu и предоставляет команды для взаимодействия с пользователем.
 */
public class AdminMenu extends Menu {
    private final ConsoleUI consoleUI;
    private final String userName;

    public AdminMenu(String userName, ConsoleUI consoleUI) {
        super(new ArrayList<>());
        this.consoleUI = consoleUI;
        this.userName = userName;
        initCommands();
    }

    protected void initCommands() {

        addCommand(new BackMenu(consoleUI));
    }
}
