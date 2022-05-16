package com.lpf.traffic.light.model3;

import com.lpf.traffic.light.CarDriveControl;
import com.lpf.traffic.light.Light;
import com.lpf.traffic.light.turn.TurnHandle;

public class MultiCarDriveControl extends CarDriveControl {
    private int count;
    private Light light;
    private TurnHandle turnHandle;

    public MultiCarDriveControl(Light light, TurnHandle turnHandle, int count) {
        super(light, turnHandle);
        this.count = count;
        this.light = light;
        this.turnHandle = turnHandle;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            CarDriveControl carDriveControl = new CarDriveControl(this.light, this.turnHandle);
            carDriveControl.start();
        }
    }
}
