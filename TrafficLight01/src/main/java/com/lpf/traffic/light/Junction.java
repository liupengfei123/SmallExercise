package com.lpf.traffic.light;


import com.lpf.traffic.light.turn.StraightHandle;

/** 路口
 * @author liupf
 */
public class Junction {

    /**
     * 北
     */
    private DriveCarHelp northDriveCarHelp;

    private DriveCarHelp northGoRightDriveCarHelp;

    /**
     * 南
     */
    private DriveCarHelp southDriveCarHelp;

    /**
     * 西
     */
    private DriveCarHelp eastDriveCarHelp;

    /**
     * 东
     */
    private DriveCarHelp westDriveCarHelp;


    // 通过 build 将  Light  road 与 DriveCarHelp 关联，

    public static class JunctionBuild {
        private DriveCarHelp northDriveCarHelp;
        private DriveCarHelp southDriveCarHelp;
        private DriveCarHelp eastDriveCarHelp;
        private DriveCarHelp westDriveCarHelp;


        public void buildNorthDriveCarHelp() {
            Light light = new Light();

            IntersectionRoad intersectionRoad = new IntersectionRoad("北");
            StraightHandle straightHandle = new StraightHandle(intersectionRoad);

            northDriveCarHelp = new DriveCarHelp(light, straightHandle);
        }


    }

}
