package model.repository;

import model.meter.MeterReading;
import model.user.User;

import java.io.BufferedReader;
import java.nio.Buffer;

public class ServiceRepository {
    private User tempUser;
    private LocalRepository localRepository;

    public ServiceRepository() {
        localRepository = new LocalRepository();
    }

    public boolean checkContainsUser(String username) {
        return localRepository.getUsers().containsKey(username);
    }

    public boolean registerUser(String username, String password) {
        localRepository.getUsers().put(username, new User(username, password));
        return true;
    }

    public boolean tryVerification(String username, String password) {
        if (localRepository.getUsers().get(username).getPassword().equals(password)) {
            this.tempUser = localRepository.getUsers().get(username);
            return true;
        } else {
            return false;
        }


    }

    /**
     * Проверить показания пользователя
     *
     * @param username
     * @return
     */
    public boolean checkContainsUserInMeter(String username) {
        return localRepository.getLatestReadings().containsKey(username);
    }

    /**
     * Проверка существует ли запись в переданном месяце
     *
     * @param month месяц
     * @return
     */
    public boolean checkMonthLatestReading(String month) {
        return localRepository.getLatestReadings().get(tempUser.getUsername()).getMonth().equals(month);
    }

    public boolean addMeterReadings(MeterReading meterReading) {
        // добавляем показания в последние
        localRepository.getLatestReadings().put(tempUser.getUsername(), meterReading);
        // добавляем пользователю показания
        localRepository.getUsers().get(tempUser.getUsername()).getMeterReadings().add(meterReading);
        return true;
    }

    public String showLatestReading() {
        MeterReading latestReading = localRepository.getLatestReadings().get(tempUser.getUsername());
        return "Latest Reading: " + latestReading.getMonth() +
                " - Heating: " + latestReading.getHeating() +
                ", Hot Water: " + latestReading.getHotWater() +
                ", Cold Water: " + latestReading.getColdWater();
    }

    public boolean checkMeterHistory() {
        return localRepository.getLatestReadings().isEmpty();
    }

    public String showMeterHistory() {
        MeterReading mr = localRepository.getLatestReadings().get(tempUser.getUsername());
        return mr.getMonth() +
                " - Heating: " + mr.getHeating() +
                ", Hot Water: " + mr.getHotWater() +
                ", Cold Water: " + mr.getColdWater();

    }

    public void exitUser() {
        tempUser = null;
    }
}
