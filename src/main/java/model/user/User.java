package model.user;

import model.meter.MeterReading;

import java.util.ArrayList;
import java.util.List;

/**
 * Пользователь
 */
public class User extends Client{

    /**
     * Данные показаний пользователя
     */
    private List<MeterReading> meterReadings;

    /**
     * Конструктор для пользователя
     * @param username
     * @param password
     */
    public User(String username, String password) {
        super(username,password);
        this.meterReadings = new ArrayList<>();
    }


    //region Getters/setters
    public List<MeterReading> getMeterReadings() {
        return meterReadings;
    }
    //endregion
}