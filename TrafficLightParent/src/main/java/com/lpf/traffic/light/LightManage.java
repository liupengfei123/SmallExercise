package com.lpf.traffic.light;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 十字路口 红绿灯信号管理
 * 左转与直行同一信号灯
 * @author liupf
 */
public final class LightManage extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(LightManage.class);
    /**
     * 北 东 南 西 顺时钟顺序点亮
     */
    private Map<Integer, Light> lightMap;

    /**
     * 红路灯切换间隔
     */
    private long switchInterval;

    private LightManageHandle lightManageHandle;

    public LightManage(LightManageHandle lightManageHandle, long switchInterval) {
        super("IntersectionLightManage Thread");
        this.switchInterval = switchInterval;
        this.lightManageHandle = lightManageHandle;
        this.lightMap = new HashMap<>();
    }


    @Override
    public void run() {
        while (true) {
            try {
                runGreen();

                Thread.sleep(switchInterval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void addLight(int position, Light light) {
        lightMap.put(position, light);
    }


    private void runGreen() {
        int greenLightKey = this.lightManageHandle.getNextGreenLight();
        lightMap.forEach((key, light) -> {
            light.setRed();

            if ((key & greenLightKey) != 0) {
                light.setGreet();
                LOGGER.info("红绿灯切换，当前绿灯为：{}", light);
            }
        });
    }




    public void setSwitchInterval(long switchInterval) {
        this.switchInterval = switchInterval;
    }
}
