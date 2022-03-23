package com.lpf.traffic.light;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 车辆驾驶帮助类
 *   用于模拟车辆在道路上等待红绿灯通行。
 *
 * @author liupf
 */
public class DriveCarHelp extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private Light light;
    private Road road;


    public DriveCarHelp(Light light, Road road) {
        this.light = light;
        this.road = road;
    }

    @Override
    public void run() {

        while (true) {
            if (light.isGreet()) {
                Car car = road.goStraight();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }

                LOGGER.info("car {}, in road: {}, go run", car, road.getName());
            }
        }
    }
}
