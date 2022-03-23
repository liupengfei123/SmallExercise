package com.lpf.traffic.light;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 十字路口 红绿灯信号管理
 * 左转与直行同一信号灯
 * @author liupf
 */
public class IntersectionLightManage extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);
    /**
     * 北 东 南 西 顺时钟顺序点亮
     */
    private Light[] lights;

    private int index = 0;

    /**
     * 红路灯切换间隔
     */
    private long switchInterval;


    public IntersectionLightManage(Light northLight, Light southLight, Light eastLight, Light westLight, long switchInterval) {
        super("IntersectionLightManage Thread");
        this.switchInterval = switchInterval;

        lights = new Light[]{northLight, eastLight, southLight, westLight};
    }


    @Override
    public void run() {
        while (true) {
            try {
                runGreen();
                nextIndex();

                Thread.sleep(switchInterval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void nextIndex() {
        index = ++index % lights.length;
    }

    private void runGreen() {
        for (Light light : lights) {
            light.setRed();
        }
        lights[index].setGreet();

        LOGGER.info("红绿灯切换，当前绿灯为：{}", lights[index]);
    }


    public void setSwitchInterval(long switchInterval) {
        this.switchInterval = switchInterval;
    }
}
