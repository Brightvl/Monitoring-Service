package model.repository;

import model.meter.MeterReading;
import model.user.Client;
import model.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранилище пользовательских данных
 */
public class LocalRepositoryUserData {
    /**
     * Словарь пользователей
     */
    private final Map<String, Client> users = new HashMap<>();
    /**
     * Коллекция последних поданных пользователем данных
     */
    private final Map<String, MeterReading> latestReadings = new HashMap<>();


    /**
     * Добавление пользователя в коллекцию
     *
     * @param username имя
     * @param user     пользователь
     */
    public void putUsers(String username, User user) {
        users.put(username, user);
    }

    /**
     * Добавляем показания пользователю
     * @param username имя
     * @param meterReading параметр
     * @return true если успешно
     */
    public boolean addMeterReadings(String username, MeterReading meterReading) {
        // добавляем пользователю показания;
        if (users.get(username) instanceof User) {
            ((User) users.get(username)).addMeterReading(meterReading);
            // добавляем показания в последние
            latestReadings.put(username, meterReading);
            return true;
        }
        return false;
    }

    //region getters/setters
    public Map<String, Client> getUsers() {
        return new HashMap<>(users);
    }

    public Map<String, MeterReading> getLatestReadings() {
        return new HashMap<>(latestReadings);
    }
    //endregion
}
