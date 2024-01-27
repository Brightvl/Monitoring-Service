package presenter;

import model.meter.MeterReading;
import model.repository.ServiceRepository;
import view.View;

public class Presenter {

    // Свойства
    private View view;
    private ServiceRepository serviceRepository;


    public Presenter(View view) {
        this.serviceRepository = new ServiceRepository();
        this.view = view;
    }

    /**
     * Зарегистрировать пользователя
     * @param username
     * @param password
     * @return
     */
    public boolean registerUser(String username, String password) {
        return serviceRepository.registerUser(username, password);
    }

    public boolean tryVerification(String username, String password) {
        return serviceRepository.tryVerification(username, password);
    }

    /**
     * Проверка существования пользователя
     * @param username
     * @return
     */
    public boolean checkUserExistence(String username) {
        return serviceRepository.checkUserExistence(username);
    }


    public boolean checkMonthLatestReading(String month) {
        return serviceRepository.checkMonthLatestReading(month);
    }


    public boolean addMeterReadings(MeterReading meterReading) {
        return serviceRepository.addMeterReadings(meterReading);
    }

    /**
     * Показать последние добавленные записи
     * @return
     */
    public String showLatestReading(String username) {
        return serviceRepository.showLatestReading(username);
    }

    public boolean checkMeterHistory() {
        return serviceRepository.checkMeterHistory();
    }

    public String showMeterHistory() {
        return serviceRepository.showMeterHistory();
    }


    /**
     * Dj время работы user menu пусть servise repository запомнит пользователя
     * @param username
     */
    public void addTempUser(String username) {
        serviceRepository.addTempUser(username);
    }

    /**
     * Когда закрывается меню пользователя пользователь обнуляется
     */
    public void exitUser() {
        serviceRepository.exitUser();
    }

    public boolean checkLatestReading(String username) {
        return serviceRepository.checkLatestReading(username);
    }
}
