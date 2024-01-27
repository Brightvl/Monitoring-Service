package model.meter;

public class MeterReading {
    private String month;
    private int heating;
    private int hotWater;
    private int coldWater;

    public MeterReading(String month, int heating, int hotWater, int coldWater) {
        this.month = month;
        this.heating = heating;
        this.hotWater = hotWater;
        this.coldWater = coldWater;
    }

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
}