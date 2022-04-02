package com.lpf.traffic.light.model1;


import com.lpf.traffic.light.Car;
import com.lpf.traffic.light.DirectionConstant;
import com.lpf.traffic.light.turn.TurnControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/** 直行和左转同车道 
 * 
 * @author liupf
 */
public class StraightAndLeftInSameLaneTurnControl implements TurnControl {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private String name;

    //模拟直行和左转道路
    private Queue<Car> queueLeftAndStraight;

    //模拟 右转道路
    private Queue<Car> queueRight;

    public StraightAndLeftInSameLaneTurnControl(String name) {
        this.name = name;

        // 暂时无视一条路上能容纳多少两车
        this.queueLeftAndStraight = new LinkedBlockingQueue<>();
        this.queueRight = new LinkedBlockingQueue<>();
    }


    @Override
    public void wantStraight(Car car) {
        queueLeftAndStraight.offer(car);
    }

    @Override
    public void wantTurnLeft(Car car) {
        wantStraight(car);
    }

    @Override
    public void wantTurnRight(Car car) {
        queueRight.offer(car);
        // 右转无需信号灯 直接驶入
        goTurnRight();
    }

    @Override
    public void goStraight() {
        Car car = queueLeftAndStraight.poll();
        if (car == null) {
            return;
        }

        if (car.getDirection() == DirectionConstant.LEFT) {
            doGoTurnLeft(car);
        } else {
            doGoStraight(car);
        }
    }

    private void doGoStraight(Car car) {
        LOGGER.info("车辆行驶情况： {}, in road: {}, go straight", car, name);
    }
    private void doGoTurnLeft(Car car) {
        LOGGER.info("车辆行驶情况： {}, in road: {}, go left", car, name);
    }

    @Override
    public void goTurnLeft() {
        throw new UnsupportedOperationException();
    }



    @Override
    public void goTurnRight() {
        Car car = queueRight.poll();
        // 直接驶出 或者下一个道路上
        LOGGER.info("车辆行驶情况： {}, in road: {}, go right", car, name);
    }
}
