package com.lpf.traffic.light.turn;

public class StraightHandle implements TurnHandle {

    private TurnControl turnControl;

    public StraightHandle(TurnControl turnControl) {
        this.turnControl = turnControl;
    }

    @Override
    public void turnCar() {
        turnControl.goStraight();
    }
}
