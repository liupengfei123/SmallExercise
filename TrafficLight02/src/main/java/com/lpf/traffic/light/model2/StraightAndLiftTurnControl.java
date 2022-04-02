package com.lpf.traffic.light.model2;


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
public class StraightAndLiftTurnControl implements TurnControl {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private String name;

    //模拟左转道路
    private Queue<Car> queueLeft;

    //模拟直行道路
    private Queue<Car> queueStraight;

    //模拟右转道路
    private Queue<Car> queueRight;

    public StraightAndLiftTurnControl(String name) {
        this.name = name;

        // 暂时无视一条路上能容纳多少两车
        this.queueLeft = new LinkedBlockingQueue<>();
        this.queueStraight = new LinkedBlockingQueue<>();
        this.queueRight = new LinkedBlockingQueue<>();
    }


    @Override
    public void wantStraight(Car car) {
        queueStraight.offer(car);
    }

    @Override
    public void wantTurnLeft(Car car) {
        queueLeft.offer(car);
    }

    @Override
    public void wantTurnRight(Car car) {
        queueRight.offer(car);
        // 右转无需信号灯 直接驶入
        goTurnRight();
    }

    @Override
    public void goStraight() {
        Car car = queueStraight.poll();
        if (car == null) {
            return;
        }
        doGoStraight(car);
    }

    @Override
    public void goTurnLeft() {
        Car car = queueLeft.poll();
        if (car == null) {
            return;
        }
        doGoTurnLeft(car);
    }


    @Override
    public void goTurnRight() {
        Car car = queueRight.poll();
        // 直接驶出 或者下一个道路上
        doGoTurnRight(car);
    }


    private void doGoStraight(Car car) {
        LOGGER.info("车辆行驶情况： {}, in road: {}, go straight", car, name);
    }
    private void doGoTurnLeft(Car car) {
        LOGGER.info("车辆行驶情况： {}, in road: {}, go left", car, name);
    }
    private void doGoTurnRight(Car car) {
        LOGGER.info("车辆行驶情况： {}, in road: {}, go right", car, name);
    }
}
