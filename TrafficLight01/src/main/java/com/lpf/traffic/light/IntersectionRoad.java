package com.lpf.traffic.light;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/** 道路
 * @author liupf
 */
public class IntersectionRoad implements Road {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private String name;

    private Queue<Car> queueLeftAndStraight;
    private Queue<Car> queueRight;

    public IntersectionRoad(String name) {
        this.name = name;

        // 暂时无视一条路上能容纳多少两车
        this.queueLeftAndStraight = new LinkedBlockingQueue<>();
        this.queueRight = new LinkedBlockingQueue<>();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void wantStraight(Car car) {
        queueLeftAndStraight.offer(car);
    }

    @Override
    public void wantTurnLeft(Car car) {
        queueLeftAndStraight.offer(car);
    }

    @Override
    public void wantTurnRight(Car car) {
        queueRight.offer(car);
    }

    @Override
    public void goStraight() {
        Car car = queueLeftAndStraight.poll();
        // todo 直接驶出 或者下一个道路上
        LOGGER.info("car {}, in road: {}, go run", car, name);
    }

    @Override
    public void goTurnLeft() {
        Car car = queueLeftAndStraight.poll();

        LOGGER.info("car {}, in road: {}, go run", car, name);
    }

    @Override
    public void goTurnRight() {
        Car car = queueRight.poll();

        LOGGER.info("car {}, in road: {}, go run", car, name);
    }
}
