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



    //region getters/setters
    public Map<String, User> getUsers() {
        return new HashMap<>(users);
    }
    public Map<String, MeterReading> getLatestReadings() {
        return latestReadings;
    }
    //endregion
}
