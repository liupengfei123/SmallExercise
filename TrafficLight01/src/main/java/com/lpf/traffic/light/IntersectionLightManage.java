package com.lpf.traffic.light;

/**
 * 十字路口 红绿灯信号管理
 * @author liupf
 */
public class IntersectionLightManage {

    /**
     * 北
     */
    private Light northLight;

    /**
     * 南
     */
    private Light southLight;

    /**
     * 西
     */
    private Light eastLight;

    /**
     * 东
     */
    private Light westLight;

    /**
     * 红路灯切换间隔
     */
    private long switchInterval;


    public IntersectionLightManage(Light northLight, Light southLight, Light eastLight, Light westLight) {
        this.northLight = northLight;
        this.southLight = southLight;
        this.eastLight = eastLight;
        this.westLight = westLight;
    }


    // todo  控制红绿灯规律切换

}
