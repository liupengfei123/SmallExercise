package com.lpf.traffic.light.model1;


import com.lpf.traffic.light.CarDriveControl;

/** 路口
 * @author liupf
 */
public class Junction {

    private CarDriveControl northCarDriveControl;
    private CarDriveControl southCarDriveControl;
    private CarDriveControl eastCarDriveControl;
    private CarDriveControl westCarDriveControl;

    private Junction() {
    }



    public void start() {
        northCarDriveControl.start();
        southCarDriveControl.start();
        eastCarDriveControl.start();
        westCarDriveControl.start();
    }

    // 通过 build 将  Light  road 与 DriveCarHelp 关联，

    public static class JunctionBuild {
        private CarDriveControl northCarDriveControl;
        private CarDriveControl southCarDriveControl;
        private CarDriveControl eastCarDriveControl;
        private CarDriveControl westCarDriveControl;


        public void buildNorthCarDriveControl(CarDriveControl temp) {
            northCarDriveControl = temp;
        }

        public void buildSouthCarDriveControl(CarDriveControl temp) {
            southCarDriveControl = temp;
        }

        public void buildEastCarDriveControl(CarDriveControl temp) {
            eastCarDriveControl = temp;
        }

        public void buildWestCarDriveControl(CarDriveControl temp) {
            westCarDriveControl = temp;
        }

        public Junction build() {
            if (northCarDriveControl == null) {
                throw new NullPointerException("northCarDriveControl cat not null");
            }
            if (southCarDriveControl == null) {
                throw new NullPointerException("northCarDriveControl cat not null");
            }
            if (eastCarDriveControl == null) {
                throw new NullPointerException("northCarDriveControl cat not null");
            }
            if (westCarDriveControl == null) {
                throw new NullPointerException("northCarDriveControl cat not null");
            }

            Junction junction = new Junction();
            junction.northCarDriveControl = this.northCarDriveControl;
            junction.southCarDriveControl = this.southCarDriveControl;
            junction.eastCarDriveControl = this.eastCarDriveControl;
            junction.westCarDriveControl = this.westCarDriveControl;

            return junction;
        }

    }

}
