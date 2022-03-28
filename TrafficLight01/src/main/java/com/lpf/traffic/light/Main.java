package com.lpf.traffic.light;

import com.lpf.traffic.light.turn.TurnControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        Light nLight = new Light("北");
        Light sLight = new Light("南");
        Light eLight = new Light("东");
        Light wLight = new Light("西");

        StraightAndLeftInSameLaneLightManageHandle handle = new StraightAndLeftInSameLaneLightManageHandle();


        LightManage lightManage = new LightManage(handle, 5000);
        lightManage.addLight(LightConstant.NORTH_STRAIGHT, nLight);
        lightManage.addLight(LightConstant.EAST_STRAIGHT, eLight);
        lightManage.addLight(LightConstant.SOUTH_STRAIGHT, sLight);
        lightManage.addLight(LightConstant.WEST_STRAIGHT, wLight);

        TurnControl northTurnControl = ObjectFactory.createStraightAndLeftInSameLaneTurnControl("北");
        TurnControl southTurnControl = ObjectFactory.createStraightAndLeftInSameLaneTurnControl("南");
        TurnControl eastTurnControl = ObjectFactory.createStraightAndLeftInSameLaneTurnControl("东");
        TurnControl westTurnControl = ObjectFactory.createStraightAndLeftInSameLaneTurnControl("西");

        Junction.JunctionBuild junctionBuild = new Junction.JunctionBuild();
        junctionBuild.buildNorthCarDriveControl(ObjectFactory.createCarDriveControl(nLight, northTurnControl));
        junctionBuild.buildSouthCarDriveControl(ObjectFactory.createCarDriveControl(sLight, southTurnControl));
        junctionBuild.buildEastCarDriveControl(ObjectFactory.createCarDriveControl(eLight, eastTurnControl));
        junctionBuild.buildWestCarDriveControl(ObjectFactory.createCarDriveControl(wLight, westTurnControl));

        Junction junction = junctionBuild.build();

        CarGenerator carGenerator = new CarGenerator(northTurnControl, southTurnControl, eastTurnControl, westTurnControl);


        carGenerator.start();
        junction.start();
        lightManage.start();
    }

}
