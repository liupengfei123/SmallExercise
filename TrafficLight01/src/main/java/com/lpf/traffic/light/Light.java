package com.lpf.traffic.light;

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

    public Light(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGreet() {
        state = GREEN;
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
