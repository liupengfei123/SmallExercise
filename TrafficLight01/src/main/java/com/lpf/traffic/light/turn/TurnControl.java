package com.lpf.traffic.light.turn;

import com.lpf.traffic.light.Car;

public interface TurnControl {

    void wantStraight(Car car);

    void wantTurnLeft(Car car);

    void wantTurnRight(Car car);


    void goStraight();

    void goTurnLeft();

    void goTurnRight();
}
