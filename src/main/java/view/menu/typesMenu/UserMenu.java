package view.menu.typesMenu;

import view.ConsoleUI;
import view.menu.Menu;
import view.menu.commands.*;

import java.util.ArrayList;

/**
 * MainMenu представляет главное меню приложения игрушечного магазина.
 * Он наследует класс Menu и предоставляет команды для взаимодействия с пользователем.
 */
public class UserMenu extends Menu {
    private boolean isRunning;
    private ConsoleUI consoleUI;
    private String userName;

    public UserMenu(String userName, ConsoleUI consoleUI) {
        super(new ArrayList());
        this.isRunning = true;
        this.consoleUI = consoleUI;
        this.userName = userName;
        initCommands();
    }

    private void initCommands() {
        addCommand(new SubmitMeterReading(userName,consoleUI));
        addCommand(new ViewLatestReading(userName,consoleUI));
        addCommand(new ViewReadingHistory(userName,consoleUI));
        addCommand(new ViewReadingsForMonth(userName,consoleUI));
        addCommand(new BackMenu(consoleUI));

    }

    public String getUserName() {
        return userName;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }


    public boolean isRunning() {
        return this.isRunning;
    }
}
