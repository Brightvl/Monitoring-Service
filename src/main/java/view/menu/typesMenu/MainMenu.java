package view.menu.typesMenu;

import view.ConsoleUI;
import view.menu.Menu;
import view.menu.commands.CloseProgram;
import view.menu.commands.LoginUser;
import view.menu.commands.SignUp;

import java.util.ArrayList;

/**
 * MainMenu представляет главное меню приложения.
 * Он наследует класс Menu и предоставляет команды для взаимодействия с пользователем.
 */
public class MainMenu extends Menu {
    private final ConsoleUI consoleUI;

    public MainMenu(ConsoleUI consoleUI) {
        super(new ArrayList<>());
        this.consoleUI = consoleUI;
        initCommands();
    }

     protected void initCommands() {
        addCommand(new SignUp(consoleUI));
        addCommand(new LoginUser(consoleUI));
        addCommand(new CloseProgram());
    }
}
