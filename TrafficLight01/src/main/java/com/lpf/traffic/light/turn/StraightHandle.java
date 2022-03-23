package com.lpf.traffic.light.turn;

import com.lpf.traffic.light.Road;

public class StraightHandle implements TurnHandle {

    private Road road;

    public StraightHandle(Road road) {
        this.road = road;
    }

    @Override
    public void turnCar() {
        road.goStraight();
    }
}
