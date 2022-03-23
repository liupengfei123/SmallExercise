package com.lpf.traffic.light;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 红绿灯信号
 * @author liupf
 */
public class Light {
    private final static int GREEN = 1;
    private final static int RED = 2;

    /** 红绿灯状态 1 -> 绿灯， 2 -> 红灯
     */
    private volatile int state = 1;

    private String name;

    private ReentrantLock lock;
    private Condition condition;

    public Light(String name) {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.name = name;
    }

    public void lock() {
        lock.lock();
    }
    public void unlock() {
        lock.unlock();
    }

    public void await() throws InterruptedException {
        condition.await();
    }

    public String getName() {
        return name;
    }

    public void setGreet() {
        lock();
        try {
            state = GREEN;
            condition.signalAll();
        } finally {
            unlock();
        }
    }

    public void setRed() {
        state = RED;
    }

    public boolean isGreet() {
        return state == GREEN;
    }

    public boolean isRed() {
        return state == RED;
    }

    @Override
    public String toString() {
        return "Light{" +
                "state=" + state +
                ", name='" + name + '\'' +
                '}';
    }
}
