package presenter;

import model.meter.MeterReading;
import model.repository.ServiceRepository;

public class Presenter {

    ServiceRepository serviceRepository;

    public Presenter() {
        serviceRepository = new ServiceRepository();
    }

    public boolean checkContainsUser(String username) {
        return serviceRepository.checkContainsUser(username);
    }

    public boolean registerUser(String username, String password) {
        return serviceRepository.registerUser(username, password);
    }

    public boolean tryVerification(String username, String password) {
        return serviceRepository.tryVerification(username, password);
    }

    public boolean checkContainsUserInMeter(String username) {
        return serviceRepository.checkContainsUserInMeter(username);
    }

    public boolean checkMonthLatestReading(String month) {
        return serviceRepository.checkMonthLatestReading(month);
    }


    public boolean addMeterReadings(MeterReading meterReading) {
        return serviceRepository.addMeterReadings(meterReading);
    }

    public String showLatestReading() {
        return serviceRepository.showLatestReading();
    }

    public boolean checkMeterHistory() {
        return serviceRepository.checkMeterHistory();
    }

    public String showMeterHistory() {
        return serviceRepository.showMeterHistory();
    }

    public void exitUser() {
        serviceRepository.exitUser();
    }
}
