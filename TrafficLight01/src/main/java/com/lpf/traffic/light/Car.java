package com.lpf.traffic.light;

public class Car {

    private int id;
    private String fromTo;
    private int direction;

    public Car(int id, String fromTo, int direction) {
        this.id = id;
        this.fromTo = fromTo;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", fromTo='" + fromTo + '\'' +
                '}';
    }
}
