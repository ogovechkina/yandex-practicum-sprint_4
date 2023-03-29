package ru.yandex.praktikum.sprint4.scooter.model;

public enum RentalPeriod {
    DAY("сутки"),
    TWO_DAYS("двое суток"),
    THREE_DAYS("трое суток");

    private final String value;

    RentalPeriod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
