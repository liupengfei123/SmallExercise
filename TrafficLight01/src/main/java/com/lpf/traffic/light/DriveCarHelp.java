package com.lpf.traffic.light;


/** 车辆驾驶帮助类
 *   用于模拟车辆在道路上等待红绿灯通行。
 *
 * @author liupf
 */
public class DriveCarHelp extends Thread{
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
                Car car = road.runOut();

                // todo 开车
            }
        }
    }
}
