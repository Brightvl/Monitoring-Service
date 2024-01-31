package model.data;

/**
 * Значения месяцев в году
 */
public enum Month {
    JANUARY("Январь"),
    FEBRUARY("Февраль"),
    MARCH("Март"),
    APRIL("Апрель"),
    MAY("Май"),
    JUNE("Июнь"),
    JULY("Июль"),
    AUGUST("Август"),
    SEPTEMBER("Сентябрь"),
    OCTOBER("Октябрь"),
    NOVEMBER("Ноябрь"),
    DECEMBER("Декабрь");

    private final String name;

    Month(String name) {
        this.name = name;
    }

    /**
     * Проверка соответствия переданного месяца
     *
     * @param month месяц
     * @return true если месяц существует
     */
    public static boolean checkMonth(String month) {
        for (Month enumMonth : Month.values()) {
            if (enumMonth.name.equalsIgnoreCase(month.trim())) {
                return true;
            }
        }
        return false;
    }
}
