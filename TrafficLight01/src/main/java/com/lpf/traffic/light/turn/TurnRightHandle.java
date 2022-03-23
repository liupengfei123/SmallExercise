package com.lpf.traffic.light.turn;

import com.lpf.traffic.light.Road;

public class TurnRightHandle implements TurnHandle {

    private Road road;

    public TurnRightHandle(Road road) {
        this.road = road;
    }

    @Override
    public void turnCar() {
        road.goTurnRight();
    }
}
