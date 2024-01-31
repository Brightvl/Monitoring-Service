package view.menu.commands;

/**
 * Интерфейс описывающий действия команд меню
 */
public interface Command {
    /**
     * Возвращает описание команды.
     *
     * @return описание команды
     */
    String getDescription();

    /**
     * Выполняет команду.
     */
    void execute();
}
