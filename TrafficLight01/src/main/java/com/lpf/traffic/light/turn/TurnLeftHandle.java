package com.lpf.traffic.light.turn;

import com.lpf.traffic.light.Road;

public class TurnLeftHandle implements TurnHandle {

    private Road road;

    public TurnLeftHandle(Road road) {
        this.road = road;
    }

    @Override
    public void turnCar() {
        road.goTurnLeft();
    }
}
