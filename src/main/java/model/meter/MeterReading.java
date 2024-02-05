package model.meter;

import lombok.Data;

/**
 * Показания счетчика
 */
@Data
public class MeterReading {
    /**
     * месяц
     */
    private final String month;
    /**
     * Отопление
     */
    private final int heating;
    /**
     * Горячая вода
     */
    private final int hotWater;
    /**
     * Холодная вода
     */
    private final int coldWater;
}