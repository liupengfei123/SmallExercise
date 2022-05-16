package com.lpf.traffic.light.model3;

import com.lpf.traffic.light.Light;
import com.lpf.traffic.light.LightConstant;
import com.lpf.traffic.light.LightManage;
import com.lpf.traffic.light.turn.TurnControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        Light nsLight = new Light("北-直行");
        Light nlLight = new Light("北-左转");
        Light ssLight = new Light("南-直行");
        Light slLight = new Light("南-左转");
        Light esLight = new Light("东-直行");
        Light elLight = new Light("东-左转");
        Light wsLight = new Light("西-直行");
        Light wlLight = new Light("西-左转");

        StraightAndLeftLightManageHandle handle = new StraightAndLeftLightManageHandle();


        LightManage lightManage = new LightManage(handle, 5000);
        lightManage.addLight(LightConstant.NORTH_STRAIGHT, nsLight);
        lightManage.addLight(LightConstant.NORTH_LEFT, nlLight);
        lightManage.addLight(LightConstant.EAST_STRAIGHT, esLight);
        lightManage.addLight(LightConstant.EAST_LEFT, elLight);
        lightManage.addLight(LightConstant.SOUTH_STRAIGHT, ssLight);
        lightManage.addLight(LightConstant.SOUTH_LEFT, slLight);
        lightManage.addLight(LightConstant.WEST_STRAIGHT, wsLight);
        lightManage.addLight(LightConstant.WEST_LEFT, wlLight);

        TurnControl northTurnControl = ObjectFactory.createStraightAndLeftTurnControl("北");
        TurnControl southTurnControl = ObjectFactory.createStraightAndLeftTurnControl("南");
        TurnControl eastTurnControl = ObjectFactory.createStraightAndLeftTurnControl("东");
        TurnControl westTurnControl = ObjectFactory.createStraightAndLeftTurnControl("西");

        Junction.JunctionBuild junctionBuild = new Junction.JunctionBuild();
        junctionBuild.buildNorthCarDriveControl(ObjectFactory.createMultiStraightCarDriveControl(nsLight, northTurnControl, 3), ObjectFactory.createLeftCarDriveControl(nlLight, northTurnControl));
        junctionBuild.buildSouthCarDriveControl(ObjectFactory.createMultiStraightCarDriveControl(ssLight, southTurnControl, 3), ObjectFactory.createLeftCarDriveControl(slLight, southTurnControl));
        junctionBuild.buildEastCarDriveControl(ObjectFactory.createMultiStraightCarDriveControl(esLight, eastTurnControl, 3), ObjectFactory.createLeftCarDriveControl(elLight, eastTurnControl));
        junctionBuild.buildWestCarDriveControl(ObjectFactory.createMultiStraightCarDriveControl(wsLight, westTurnControl, 3), ObjectFactory.createLeftCarDriveControl(wlLight, westTurnControl));

        Junction junction = junctionBuild.build();

        CarGenerator carGenerator = new CarGenerator(northTurnControl, southTurnControl, eastTurnControl, westTurnControl);

        carGenerator.start();
        junction.start();
        lightManage.start();
    }

}
