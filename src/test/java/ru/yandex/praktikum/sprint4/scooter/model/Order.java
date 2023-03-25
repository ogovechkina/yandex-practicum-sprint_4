package ru.yandex.praktikum.sprint4.scooter.model;

import java.time.LocalDate;

public class Order {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String station;
    private final String phone;
    private final LocalDate deliveryDate;
    private final RentalPeriod rentalPeriod;
    private final Color color;

    private final String comment;

    public Order(String firstName, String lastName, String address, String station, String phone, LocalDate deliveryDate, RentalPeriod rentalPeriod, Color color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getStation() {
        return station;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public RentalPeriod getRentalPeriod() {
        return rentalPeriod;
    }

    public Color getColor() {
        return color;
    }

    public String getComment() {
        return comment;
    }
}
