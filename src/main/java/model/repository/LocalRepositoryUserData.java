package model.repository;

import model.meter.MeterReading;
import model.user.Admin;
import model.user.Client;
import model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище пользовательских данных
 */
public class LocalRepositoryUserData {
    /**
     * Словарь пользователей
     */
    private final List<Client> clients;
    /**
     * Коллекция последних поданных пользователем данных
     */
    private final Map<String, MeterReading> latestReadings;

    public LocalRepositoryUserData() {
        this.clients = new ArrayList<>();
        this.latestReadings = new HashMap<>();
        initializeList();
    }

    /**
     * Инициализация начальных пользователей
     */
    private void initializeList() {
        clients.add(new Admin("Adam", "1234"));
    }

    /**
     * Добавление пользователя в коллекцию
     *
     * @param user     пользователь
     */
    public void addUsers(User user) {
        clients.add(user);
    }

    /**
     * Добавляем показания пользователю
     *
     * @param username     имя
     * @param meterReading параметр
     * @return true если успешно
     */
    public boolean addMeterReadings(String username, MeterReading meterReading) {
        if (getClientByName(username) instanceof User) {
            ((User) getClientByName(username)).addMeterReading(meterReading);
            latestReadings.put(username, meterReading);
            return true;
        }
        return false;
    }

    /**
     * Возвращает пользователя по имени
     * @param clientName имя пользователя
     * @return client
     */
    public Client getClientByName(String clientName) {
        for (Client client : clients) {
            if (client.getUsername().equalsIgnoreCase(clientName)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Проверяет есть ли пользователь в списке
     * @param clientName имя
     * @return true если да
     */
    public boolean checkClientExistence(String clientName) {
        for (Client client : clients) {
            if (client.getUsername().equalsIgnoreCase(clientName)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, MeterReading> getLatestReadings() {
        return new HashMap<>(latestReadings);
    }

}
