package presenter;

import model.ServiceRepository;
import model.meter.MeterReading;
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
    private final ServiceRepository serviceRepository;


    public Presenter(View view) {
        this.serviceRepository = new ServiceRepository();
        this.view = view;
    }

    /**
     * Зарегистрировать пользователя
     *
     * @param username имя
     * @param password пароль
     * @return true если успешно
     */
    public boolean registerUser(String username, String password) {
        return serviceRepository.registerUser(username, password);
    }

    /**
     * Попытка верификации
     *
     * @param username имя
     * @param password пароль
     * @return true если успешно
     */
    public boolean tryVerification(String username, String password) {
        return serviceRepository.tryVerification(username, password);
    }

    /**
     * Проверка существования пользователя
     *
     * @param username имя
     * @return true если существует
     */
    public boolean checkUserExistence(String username) {
        return serviceRepository.checkUserExistence(username);
    }


    /**
     * Проверка существования последней записи
     *
     * @param month месяц
     * @return true если существует
     */
    public boolean checkMonthLatestReading(String month) {
        return serviceRepository.checkMonthLatestReading(month);
    }

    /**
     * Отобразить показания за выбранный месяц
     *
     * @param month месяц
     * @return строка с месяцами
     */
    public String showReadingsForMonth(String month) {
        return serviceRepository.getReadingsForMonth(month);
    }

    /**
     * Добавить показания
     *
     * @param meterReading показания
     * @return true если успешно
     */
    public boolean addMeterReadings(MeterReading meterReading) {
        return serviceRepository.addMeterReadings(meterReading);
    }


    /**
     * Проверить существование истории подачи показаний
     *
     * @return true если существует
     */
    public boolean checkMeterHistory() {
        return serviceRepository.checkMeterHistory();
    }

    /**
     * Показать историю подачи показаний
     *
     * @return true если существует история
     */
    public String showMeterHistory() {
        return serviceRepository.showMeterHistory();
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
     * @return true если существует
     */
    public boolean checkLatestReading() {
        return serviceRepository.checkLatestReading();
    }

    /**
     * Показать последние добавленные записи
     *
     * @return строку с записью
     */
    public String showLatestReading(String username) {
        return serviceRepository.showLatestReading(username);
    }

    public boolean checkOnAdmin() {
        return serviceRepository.checkOnAdmin();
    }

    public String showAllLatestReading() {
        return serviceRepository.showAllLatestReading();
    }
}
