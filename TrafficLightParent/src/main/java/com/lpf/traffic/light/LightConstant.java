package com.lpf.traffic.light;

public interface LightConstant {

    int NORTH_LEFT = 1;
    int NORTH_STRAIGHT = 1 << 1;
    int NORTH_RIGHT = 1 << 2;


    int EAST_LEFT = 1 << 4;
    int EAST_STRAIGHT = 1 << 5;
    int EAST_RIGHT = 1 << 6;


    int SOUTH_LEFT = 1 << 8;
    int SOUTH_STRAIGHT = 1 << 9;
    int SOUTH_RIGHT = 1 << 10;


    int WEST_LEFT = 1 << 12;
    int WEST_STRAIGHT = 1 << 13;
    int WEST_RIGHT = 1 << 14;
}
