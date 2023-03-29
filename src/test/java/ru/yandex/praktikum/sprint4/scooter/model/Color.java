package ru.yandex.praktikum.sprint4.scooter.model;

public enum Color {

    BLACK("чёрный жемчуг"),
    GREY("серая безысходность");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
