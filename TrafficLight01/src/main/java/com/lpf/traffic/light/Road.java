package com.lpf.traffic.light;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/** 道路
 * @author liupf
 */
public class Road {

    private Queue<Car> queue;

    public Road() {
        // 暂时无视一条路上能容纳多少两车
        this.queue = new LinkedBlockingQueue<Car>();
    }


    public void runInto(Car car) {
        queue.offer(car);
    }

    public Car runOut() {
        return queue.poll();
    }
}
