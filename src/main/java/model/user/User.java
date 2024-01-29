package model.user;

import model.meter.MeterReading;

import java.util.ArrayList;
import java.util.List;

//todo 11. Не реализован функционал администратора
/**
 * Пользователь
 */
public class User {
    /**
     * имя
     */
    private String username;
    /**
     * пароль
     */
    private String password;
    /**
     * состояние админ или нет
     */
    private boolean isAdmin;
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
        this.username = username;
        this.password = password;
        this.meterReadings = new ArrayList<>();
    }

    /**
     * Конструктор для админа
     * @param username
     * @param password
     * @param isAdmin
     */
    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.meterReadings = new ArrayList<>();
        this.isAdmin = isAdmin;
    }


    //region Getters/setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<MeterReading> getMeterReadings() {
        return meterReadings;
    }
    //endregion
}