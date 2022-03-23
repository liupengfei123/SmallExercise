package com.lpf.traffic.light;

public interface Road {

    String getName();

    void wantStraight(Car car);

    void wantTurnLeft(Car car);

    void wantTurnRight(Car car);


    Car goStraight();

    Car goTurnLeft();

    Car goTurnRight();
}
