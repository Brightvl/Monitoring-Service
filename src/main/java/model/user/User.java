package model.user;

import model.meter.MeterReading;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<MeterReading> meterReadings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.meterReadings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<MeterReading> getMeterReadings() {
        return meterReadings;
    }
}