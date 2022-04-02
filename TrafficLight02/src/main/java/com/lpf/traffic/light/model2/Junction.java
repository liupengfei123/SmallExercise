package com.lpf.traffic.light.model2;


import com.lpf.traffic.light.CarDriveControl;

/** 路口
 * @author liupf
 */
public class Junction {

    private CarDriveControl northStraightCarDriveControl;
    private CarDriveControl northLeftCarDriveControl;
    private CarDriveControl southStraightCarDriveControl;
    private CarDriveControl southLeftCarDriveControl;
    private CarDriveControl eastStraightCarDriveControl;
    private CarDriveControl eastLeftCarDriveControl;
    private CarDriveControl westStraightCarDriveControl;
    private CarDriveControl westLeftCarDriveControl;

    private Junction() {
    }


    public void start() {
        northStraightCarDriveControl.start();
        northLeftCarDriveControl.start();
        southStraightCarDriveControl.start();
        southLeftCarDriveControl.start();
        eastStraightCarDriveControl.start();
        eastLeftCarDriveControl.start();
        westStraightCarDriveControl.start();
        westLeftCarDriveControl.start();
    }

    // 通过 build 将  Light  road 与 DriveCarHelp 关联，

    public static class JunctionBuild {
        private CarDriveControl northStraightCarDriveControl;
        private CarDriveControl northLeftCarDriveControl;
        private CarDriveControl southStraightCarDriveControl;
        private CarDriveControl southLeftCarDriveControl;
        private CarDriveControl eastStraightCarDriveControl;
        private CarDriveControl eastLeftCarDriveControl;
        private CarDriveControl westStraightCarDriveControl;
        private CarDriveControl westLeftCarDriveControl;


        public void buildNorthCarDriveControl(CarDriveControl straight, CarDriveControl left) {
            northStraightCarDriveControl = straight;
            northLeftCarDriveControl = left;
        }

        public void buildSouthCarDriveControl(CarDriveControl straight, CarDriveControl left) {
            southStraightCarDriveControl = straight;
            southLeftCarDriveControl = left;
        }

        public void buildEastCarDriveControl(CarDriveControl straight, CarDriveControl left) {
            eastStraightCarDriveControl = straight;
            eastLeftCarDriveControl = left;
        }

        public void buildWestCarDriveControl(CarDriveControl straight, CarDriveControl left) {
            westStraightCarDriveControl = straight;
            westLeftCarDriveControl = left;
        }

        public Junction build() {
            if (northStraightCarDriveControl == null) {
                throw new NullPointerException("northStraightCarDriveControl cat not null");
            }
            if (northLeftCarDriveControl == null) {
                throw new NullPointerException("northLeftCarDriveControl cat not null");
            }
            if (southStraightCarDriveControl == null) {
                throw new NullPointerException("southStraightCarDriveControl cat not null");
            }
            if (southLeftCarDriveControl == null) {
                throw new NullPointerException("southLeftCarDriveControl cat not null");
            }

            if (eastStraightCarDriveControl == null) {
                throw new NullPointerException("eastStraightCarDriveControl cat not null");
            }
            if (eastLeftCarDriveControl == null) {
                throw new NullPointerException("eastLeftCarDriveControl cat not null");
            }
            if (westStraightCarDriveControl == null) {
                throw new NullPointerException("westStraightCarDriveControl cat not null");
            }
            if (westLeftCarDriveControl == null) {
                throw new NullPointerException("westLeftCarDriveControl cat not null");
            }

            Junction junction = new Junction();

            junction.northStraightCarDriveControl = this.northStraightCarDriveControl;
            junction.northLeftCarDriveControl = this.northLeftCarDriveControl;
            junction.southStraightCarDriveControl = this.southStraightCarDriveControl;
            junction.southLeftCarDriveControl = this.southLeftCarDriveControl;
            junction.eastStraightCarDriveControl = this.eastStraightCarDriveControl;
            junction.eastLeftCarDriveControl = this.eastLeftCarDriveControl;
            junction.westStraightCarDriveControl = this.westStraightCarDriveControl;
            junction.westLeftCarDriveControl = this.westLeftCarDriveControl;

            return junction;
        }

    }

}
