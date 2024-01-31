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
    private final LocalRepositoryUserData localRepository;

    public ServiceRepository() {
        localRepository = new LocalRepositoryUserData();
    }


    /**
     * Зарегистрировать пользователя
     *
     * @param username имя
     * @param password пароль
     * @return true если регистрация успешна
     */
    public boolean registerUser(String username, String password) {
        try {
            localRepository.putUsers(username, new User(username, password));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Верификация пользователя
     *
     * @param username имя
     * @param password пароль
     * @return true если верификация успешна
     */
    public boolean tryVerification(String username, String password) {
        return localRepository.getUsers().get(username).getPassword().equals(password);
    }

    /**
     * Проверка существования пользователя
     *
     * @param username имя
     * @return возвращает true если пользователь существует
     */
    public boolean checkUserExistence(String username) {
        return localRepository.getUsers().containsKey(username);
    }

    /**
     * Проверяет последние добавленные записи
     *
     * @param month месяц
     * @return true если запись существует
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
     * @param meterReading показание
     * @return true если все успешно
     */
    public boolean addMeterReadings(MeterReading meterReading) {
        if (localRepository.getUsers().containsKey(tempUser.getUsername())) {
            localRepository.addMeterReadings(tempUser.getUsername(), meterReading);
            return true;
        }
        return false;
    }

    /**
     * Показать последнее добавленное показание
     *
     * @param username имя
     * @return строку
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
     * @return true если история существует
     */
    public boolean checkMeterHistory() {
        return localRepository.getUsers().get(tempUser.getUsername()).getMeterReadings().isEmpty();
    }

    /**
     * Отобразить историю подачи показаний
     *
     * @return строка
     */
    public String showMeterHistory() {
        List<MeterReading> listMR = localRepository.getUsers().get(tempUser.getUsername()).getMeterReadings();
        StringBuilder stringBuilder = new StringBuilder();
        for (MeterReading mr : listMR) {
            stringBuilder.append(mr.getMonth()).append(" - Отопление: ")
                    .append(mr.getHeating())
                    .append(", Горячая вода: ")
                    .append(mr.getHotWater())
                    .append(", Холодная вода: ")
                    .append(mr.getColdWater())
                    .append("\n");
        }
        return stringBuilder.toString();

    }

    /**
     * Добавляет временного пользователя для работы с ним
     *
     * @param username имя
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

    /**
     * Проверка существуют ли показания в последних добавленных
     * @param username имя
     * @return true если существует
     */
    public boolean checkLatestReading(String username) {
        return localRepository.getLatestReadings().containsKey(username);
    }

    /**
     * Вернуть запись переданного месяца
     *
     * @param username имя
     * @param month месяц
     * @return строка
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
        return month + ": не имеет показаний счетчика";
    }
}
