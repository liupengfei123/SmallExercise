package com.lpf.traffic.light;

public class Car {

    private int id;
    private String fromTo;

    public Car(int id, String fromTo) {
        this.id = id;
        this.fromTo = fromTo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", fromTo='" + fromTo + '\'' +
                '}';
    }
}
