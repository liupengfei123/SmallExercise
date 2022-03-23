package com.lpf.traffic.light;


import com.lpf.traffic.light.turn.StraightAndLeftInSameLaneTurnControl;
import com.lpf.traffic.light.turn.StraightHandle;
import com.lpf.traffic.light.turn.TurnControl;
import com.lpf.traffic.light.turn.TurnHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 车辆驾驶帮助类
 *   用于模拟车辆在道路上等待红绿灯通行。
 *
 * @author liupf
 */
public class ObjectFactory {


    public static CarDriveControl createCarDriveControl(Light light, TurnControl intersectionRoad) {
        StraightHandle straightHandle = new StraightHandle(intersectionRoad);

        return new CarDriveControl(light, straightHandle);
    }

    public static TurnControl createStraightAndLeftInSameLaneTurnControl(String turnControlName) {
        return new StraightAndLeftInSameLaneTurnControl(turnControlName);
    }

}
