package model.user;

import model.meter.MeterReading;

import java.util.ArrayList;
import java.util.List;

/**
 * Пользователь
 */
public class User extends Client {

    /**
     * Данные показаний пользователя
     */
    private final List<MeterReading> meterReadings;


    public User(String username, String password) {
        super(username, password);
        this.meterReadings = new ArrayList<>();
    }

    /**
     * Возвращает копию показаний счетчика
     *
     * @return List<MeterReading>
     */
    public List<MeterReading> getMeterReadings() {
        return new ArrayList<>(meterReadings);
    }

    /**
     * Добавляет показание пользователю
     *
     * @param meterReading показания счетчика
     */
    public void addMeterReading(MeterReading meterReading) {
        meterReadings.add(meterReading);
    }

}