package com.lpf.traffic.light;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/** 道路
 * @author liupf
 */
public class IntersectionRoad implements Road {

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
    public Car goStraight() {
        return queueLeftAndStraight.poll();
    }

    @Override
    public Car goTurnLeft() {
        return queueLeftAndStraight.poll();
    }

    @Override
    public Car goTurnRight() {
        return queueRight.poll();
    }
}
