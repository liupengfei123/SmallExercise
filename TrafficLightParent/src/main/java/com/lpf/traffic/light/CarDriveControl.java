package com.lpf.traffic.light;


import com.lpf.traffic.light.turn.TurnHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 车辆驾驶帮助类
 * 用于模拟车辆在道路上等待红绿灯通行。
 *
 * @author liupf
 */
public class CarDriveControl extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(CarDriveControl.class);

    private Light light;
    private TurnHandle turnHandle;


    public CarDriveControl(Light light, TurnHandle turnHandle) {
        super("CarDriveControl thread");

        this.light = light;
        this.turnHandle = turnHandle;
    }

    @Override
    public void run() {
        while (true) {
            light.lock();
            try {
                // 只是为了红灯时线程休眠减少消耗
                while (light.isRed()) {
                    light.await();
                }
            } catch (InterruptedException e) {
                break;
            } finally {
                light.unlock();
            }
            try {
                if (light.isGreet()) {
                    turnHandle.turnCar();

                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
