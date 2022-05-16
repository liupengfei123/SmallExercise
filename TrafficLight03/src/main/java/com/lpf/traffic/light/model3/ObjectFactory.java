package com.lpf.traffic.light.model3;


import com.lpf.traffic.light.CarDriveControl;
import com.lpf.traffic.light.Light;
import com.lpf.traffic.light.turn.StraightHandle;
import com.lpf.traffic.light.turn.TurnControl;
import com.lpf.traffic.light.turn.TurnLeftHandle;

/** 车辆驾驶帮助类
 *   用于模拟车辆在道路上等待红绿灯通行。
 *
 * @author liupf
 */
public class ObjectFactory {


    public static CarDriveControl createMultiStraightCarDriveControl(Light light, TurnControl intersectionRoad, int count) {
        StraightHandle straightHandle = new StraightHandle(intersectionRoad);

        return new MultiCarDriveControl(light, straightHandle, count);
    }

    public static CarDriveControl createLeftCarDriveControl(Light light, TurnControl intersectionRoad) {
        TurnLeftHandle straightHandle = new TurnLeftHandle(intersectionRoad);

        return new CarDriveControl(light, straightHandle);
    }

    public static TurnControl createStraightAndLeftTurnControl(String turnControlName) {
        return new StraightAndLiftTurnControl(turnControlName);
    }

}
