package com.lpf.traffic.light.model2;

import com.lpf.traffic.light.LightConstant;
import com.lpf.traffic.light.LightManageHandle;

public class StraightAndLeftLightManageHandle implements LightManageHandle {

    private int index;
    private int[] lightIndex;


    public StraightAndLeftLightManageHandle() {
        this.index = 0;
        lightIndex = new int[]{LightConstant.NORTH_STRAIGHT | LightConstant.SOUTH_STRAIGHT,
                LightConstant.NORTH_LEFT | LightConstant.SOUTH_LEFT,
                LightConstant.EAST_STRAIGHT | LightConstant.WEST_STRAIGHT,
                LightConstant.EAST_LEFT | LightConstant.WEST_LEFT};
    }

    @Override
    public int getNextGreenLight() {
        int result = lightIndex[index];
        nextIndex();
        return result;
    }

    private void nextIndex() {
        index = ++index % lightIndex.length;
    }
}
