package model.data;

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


    public static Month getByIndex(int index) {

        if (index >= 0 && index < values().length) {
            return values()[index];
        }
        throw new IllegalArgumentException("Недопустимый индекс");
    }


    public static boolean checkMonth(String month) throws IllegalArgumentException {
        for (Month enumMonth : Month.values()) {
            if (enumMonth.name.equalsIgnoreCase(month)) {
                return true;
            }
        }
        return false;
    }
}
