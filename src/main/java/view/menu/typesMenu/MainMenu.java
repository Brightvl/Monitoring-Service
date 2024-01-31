package view.menu.typesMenu;

import view.ConsoleUI;
import view.menu.Menu;
import view.menu.commands.CloseProgram;
import view.menu.commands.LoginUser;
import view.menu.commands.SignUp;

import java.util.ArrayList;

/**
 * MainMenu представляет главное меню приложения игрушечного магазина.
 * Он наследует класс Menu и предоставляет команды для взаимодействия с пользователем.
 */
public class MainMenu extends Menu {
    private boolean isRunning;
    private ConsoleUI consoleUI;

    public MainMenu(ConsoleUI consoleUI) {
        super(new ArrayList());
        this.isRunning = true;
        this.consoleUI = consoleUI;
        initCommands();
    }

    private void initCommands() {
        addCommand(new SignUp(consoleUI));
        addCommand(new LoginUser(consoleUI));
        addCommand(new CloseProgram(consoleUI));
    }


    public void setRunning(boolean running) {
        this.isRunning = running;
    }


    public boolean isRunning() {
        return this.isRunning;
    }
}
