package model.meter;

/**
 * Показания счетчика
 */
public class MeterReading {
    /**
     * месяц
     */
    private String month;
    /**
     * Отопление
     */
    private int heating;
    /**
     * Горячая вода
     */
    private int hotWater;
    /**
     * Холодная вода
     */
    private int coldWater;

    public MeterReading(String month, int heating, int hotWater, int coldWater) {
        this.month = month;
        this.heating = heating;
        this.hotWater = hotWater;
        this.coldWater = coldWater;
    }

    //region get/set
    public String getMonth() {
        return month;
    }

    public int getHeating() {
        return heating;
    }

    public int getHotWater() {
        return hotWater;
    }

    public int getColdWater() {
        return coldWater;
    }
    //endregion
}