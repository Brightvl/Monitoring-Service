package presenter;

import model.meter.MeterReading;
import model.repository.ServiceRepository;
import view.View;

/**
 * Служит связующим звеном между бизнес логикой и выводом UI
 */
public class Presenter {

    /**
     * Любое представление Ui
     */
    private View view;
    /**
     * Сервис для удобной работы с классами хранящими данные показаний и пользователя
     */
    private ServiceRepository serviceRepository;


    public Presenter(View view) {
        this.serviceRepository = new ServiceRepository();
        this.view = view;
    }

    /**
     * Зарегистрировать пользователя
     *
     * @param username
     * @param password
     * @return
     */
    public boolean registerUser(String username, String password) {
        return serviceRepository.registerUser(username, password);
    }

    /**
     * Попытка верификации
     *
     * @param username имя
     * @param password пароль
     * @return true при успешной
     */
    public boolean tryVerification(String username, String password) {
        return serviceRepository.tryVerification(username, password);
    }

    /**
     * Проверка существования пользователя
     *
     * @param username
     * @return
     */
    public boolean checkUserExistence(String username) {
        return serviceRepository.checkUserExistence(username);
    }


    /**
     * Проверка существования последней записи
     *
     * @param month
     * @return
     */
    public boolean checkMonthLatestReading(String month) {
        return serviceRepository.checkMonthLatestReading(month);
    }

    /**
     * Отобразить показания за выбранный месяц
     *
     * @param username
     * @param month
     * @return
     */
    public String showReadingsForMonth(String username, String month) {
        return serviceRepository.getReadingsForMonth(username, month);
    }

    /**
     * Добавить показания
     *
     * @param meterReading
     * @return
     */
    public boolean addMeterReadings(MeterReading meterReading) {
        return serviceRepository.addMeterReadings(meterReading);
    }


    /**
     * Проверить существование истории подачи показаний
     *
     * @return
     */
    public boolean checkMeterHistory() {
        return serviceRepository.checkMeterHistory();
    }

    /**
     * Показать историю подачи показаний
     *
     * @return
     */
    public String showMeterHistory() {
        return serviceRepository.showMeterHistory();
    }


    /**
     * Во время работы user menu пусть servise repository запомнит пользователя
     *
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

    /**
     * Проверить существование последней добавленной записи
     *
     * @param username
     * @return
     */
    public boolean checkLatestReading(String username) {
        return serviceRepository.checkLatestReading(username);
    }

    /**
     * Показать последние добавленные записи
     *
     * @return
     */
    public String showLatestReading(String username) {
        return serviceRepository.showLatestReading(username);
    }
}
