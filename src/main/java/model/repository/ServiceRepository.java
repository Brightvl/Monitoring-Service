package model.repository;

import model.meter.MeterReading;
import model.user.User;

import java.util.List;

/**
 * Сервис соединяет Presenter и конкретную бизнес логику классов
 */
public class ServiceRepository {
    /**
     * Временно сохраняемый пользователь, на время пока находимся в личном кабинете
     */
    private User tempUser;
    /**
     * Хранилище данных пользователей
     */
    private LocalRepositoryUserData localRepository;

    public ServiceRepository() {
        localRepository = new LocalRepositoryUserData();
    }


    /**
     * Зарегистрировать пользователя
     *
     * @param username
     * @param password
     * @return
     */
    public boolean registerUser(String username, String password) {
        try {
            localRepository.getUsers().put(username, new User(username, password));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Верификация пользователя
     *
     * @param username
     * @param password
     * @return
     */
    public boolean tryVerification(String username, String password) {
        if (localRepository.getUsers().get(username).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Проверка существования пользователя
     *
     * @param username
     * @return
     */
    public boolean checkUserExistence(String username) {
        return localRepository.getUsers().containsKey(username);
    }

    /**
     * Проверяет последние добавленные записи
     *
     * @param month месяц
     * @return
     */
    public boolean checkMonthLatestReading(String month) {
        try {
            return localRepository.getLatestReadings().get(tempUser.getUsername()).getMonth().equals(month);
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Добавить показания пользователя
     *
     * @param meterReading
     * @return
     */
    public boolean addMeterReadings(MeterReading meterReading) {
        if (localRepository.getUsers().containsKey(tempUser.getUsername())) {
            // добавляем пользователю показания
            localRepository.getUsers().get(tempUser.getUsername()).getMeterReadings().add(meterReading);
            // добавляем показания в последние
            localRepository.getLatestReadings().put(tempUser.getUsername(), meterReading);
            return true;
        }
        return false;
    }

    /**
     * Показать последнее добавленное показание
     *
     * @param username
     * @return
     */
    public String showLatestReading(String username) {
        MeterReading latestReading = localRepository.getLatestReadings().get(username);
        return "Последнее добавленное: " + latestReading.getMonth() +
                " - Отопление: " + latestReading.getHeating() +
                ", Горячая вода: " + latestReading.getHotWater() +
                ", Холодная вода: " + latestReading.getColdWater();
    }

    /**
     * Проверка истории показаний
     *
     * @return
     */
    public boolean checkMeterHistory() {
        return localRepository.getLatestReadings().isEmpty();
    }

    /**
     * Отобразить историю подачи показаний
     *
     * @return
     */
    public String showMeterHistory() {
        List<MeterReading> listMR = localRepository.getUsers().get(tempUser.getUsername()).getMeterReadings();
        StringBuilder stringBuilder = new StringBuilder();
        for (MeterReading mr : listMR) {
            stringBuilder.append(mr.getMonth() +
                    " - Отопление: " + mr.getHeating() +
                    ", Горячая вода: " + mr.getHotWater() +
                    ", Холодная вода: " + mr.getColdWater() + "\n");
        }
        return stringBuilder.toString();

    }

    /**
     * Добавляет временного пользователя для работы с ним
     *
     * @param username
     */
    public void addTempUser(String username) {
        this.tempUser = localRepository.getUsers().get(username);
    }

    /**
     * Когда закрывается меню пользователя пользователь обнуляется
     */
    public void exitUser() {
        tempUser = null;
    }

    public boolean checkLatestReading(String username) {
        return localRepository.getLatestReadings().containsKey(username);
    }

    /**
     * Вернуть запись переданного месяца
     * @param username
     * @param month
     * @return
     */
    public String getReadingsForMonth(String username, String month) {
        List<MeterReading> listMR = localRepository.getUsers().get(username).getMeterReadings();
        for (MeterReading mr : listMR) {
            if (mr.getMonth().equalsIgnoreCase(month)) {
                return "Показания в " + month + ": " +
                        " - Отопление: " + mr.getHeating() +
                        ", Горячая вода: " + mr.getHotWater() +
                        ", Холодная вода: " + mr.getColdWater();
            }
        }
        return month+ ": не имеет показаний счетчика" ;
    }
}
