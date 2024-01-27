package model.repository;

import model.meter.MeterReading;
import model.user.User;

import java.util.HashMap;
import java.util.Map;

public class LocalRepository {
    // пользователи
    private Map<String, User> users = new HashMap<>();

    private Map<String, MeterReading> latestReadings = new HashMap<>();

    public  Map<String, User> getUsers() {
        return users;
    }

    public  Map<String, MeterReading> getLatestReadings() {
        return latestReadings;
    }
    static {

    }


}
