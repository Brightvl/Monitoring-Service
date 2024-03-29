package model.repository;

import model.meter.MeterReading;
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
    private Map<String, User> users = new HashMap<>();
    /**
     * Коллекция последних поданных пользователем данных
     */
    private Map<String, MeterReading> latestReadings = new HashMap<>();


    /**
     * Добавление пользователя в коллекцию
     * @param username
     * @param user
     */
    public void putUsers(String username, User user) {
        users.put(username, user);
    }

    /**
     * Добавляем показания пользователю
     * @param username
     * @param meterReading
     */
    public void addMeterReadings(String username, MeterReading meterReading) {
        // добавляем пользователю показания;
        users.get(username).getMeterReadings().add(meterReading);
        // добавляем показания в последние
        latestReadings.put(username, meterReading);
    }

    //region getters/setters
    public Map<String, User> getUsers() {
        return new HashMap<>(users);
    }

    public Map<String, MeterReading> getLatestReadings() {
        return new HashMap<>(latestReadings);
    }
    //endregion
}
