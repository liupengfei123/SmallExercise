package com.lpf.traffic.light;

public class StraightAndLeftInSameLaneLightManageHandle implements LightManageHandle {

    private int index;
    private int[] lightIndex;


    public StraightAndLeftInSameLaneLightManageHandle() {
        this.index = 0;
        lightIndex = new int[]{LightConstant.NORTH_STRAIGHT, LightConstant.EAST_STRAIGHT, LightConstant.SOUTH_STRAIGHT, LightConstant.WEST_STRAIGHT};
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
