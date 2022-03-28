package com.lpf.traffic.light.turn;

public class TurnLeftHandle implements TurnHandle {

    private TurnControl turnControl;

    public TurnLeftHandle(TurnControl turnControl) {
        this.turnControl = turnControl;
    }

    @Override
    public void turnCar() {
        turnControl.goTurnLeft();
    }
}
