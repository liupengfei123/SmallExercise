package com.lpf.traffic.light.turn;

public class TurnRightHandle implements TurnHandle {

    private TurnControl turnControl;

    public TurnRightHandle(TurnControl turnControl) {
        this.turnControl = turnControl;
    }

    @Override
    public void turnCar() {
        turnControl.goTurnRight();
    }
}
