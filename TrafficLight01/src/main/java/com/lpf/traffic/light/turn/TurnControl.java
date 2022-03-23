package com.lpf.traffic.light.turn;

import com.lpf.traffic.light.Car;

/**
 * 转向控制器，用于控制路口一个方向中的车流进入和转向驶出
 */
public interface TurnControl {

    /**
     * 车辆想要进入直走车道
     * @param car  进入车道车辆
     */
    void wantStraight(Car car);

    /**
     * 车辆想要进入左转车道
     * @param car  进入车道车辆
     */
    void wantTurnLeft(Car car);

    /**
     * 车辆想要进入右转车道
     * @param car   进入车道车辆
     */
    void wantTurnRight(Car car);


    /**
     * 将车道中的车辆直走
     */
    void goStraight();

    /**
     * 将车道中的车辆左拐
     */
    void goTurnLeft();

    /**
     * 将车道中的车辆右拐
     */
    void goTurnRight();
}
