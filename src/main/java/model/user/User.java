package model.user;

import model.meter.MeterReading;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private boolean isAdmin;
    private List<MeterReading> meterReadings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.meterReadings = new ArrayList<>();
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.meterReadings = new ArrayList<>();
        this.isAdmin = isAdmin;
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