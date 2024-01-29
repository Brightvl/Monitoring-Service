package model.repository;

import model.meter.MeterReading;
import model.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранилище данных пользователей
 */
public class LocalRepository {
    // пользователи
    private Map<String, User> users = new HashMap<>();
    // последние записи
    private Map<String, MeterReading> latestReadings = new HashMap<>();



    //region getters/setters
    public Map<String, User> getUsers() {
        return users;
    }
    public Map<String, MeterReading> getLatestReadings() {
        return latestReadings;
    }
    //endregion
}
