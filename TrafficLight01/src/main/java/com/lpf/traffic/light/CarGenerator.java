package com.lpf.traffic.light;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/** 随机车辆生成器
 * @author liupf
 */
public class CarGenerator extends Thread{

    /** 北 东 南 西
     *
     *  左  直  右
     */
    private static final String[][] fromToInfos = new String[][]{{"from 北 to 东", "from 北 to 南", "from 北 to 西"},
            {"from 东 to 南", "from 东 to 西", "from 东 to 北"},
            {"from 南 to 西", "from 南 to 北", "from 南 to 东"},
            {"from 西 to 北", "from 西 to 东", "from 西 to 南"}};


    private AtomicInteger idGenerator;

    private Road northRoad;

    private Road southRoad;

    private Road eastRoad;

    private Road westRoad;


    public CarGenerator(Road northRoad, Road southRoad, Road eastRoad, Road westRoad) {
        super("CarGenerator Thread");
        idGenerator = new AtomicInteger(0);

        this.northRoad = northRoad;
        this.southRoad = southRoad;
        this.eastRoad = eastRoad;
        this.westRoad = westRoad;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));

                createRandomCarToRoad();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void createRandomCarToRoad() {
        int value = ThreadLocalRandom.current().nextInt(12);

        int roadIndex = value / 4;
        int directionIndex = value % 4;

        Car car = new Car(idGenerator.addAndGet(1), fromToInfos[roadIndex][directionIndex]);

        Road road = null;
        switch (roadIndex) {
            case 0 : road = northRoad; break;
            case 1 : road = eastRoad; break;
            case 2 : road = southRoad; break;
            case 3 : road = westRoad; break;
        }

        carToRoad(car, road, directionIndex);
    }

    private void carToRoad(Car car, Road road, int directionIndex) {
        switch (directionIndex) {
            case 0 : road.wantTurnLeft(car); break;
            case 1 : road.wantStraight(car); break;
            case 2 : road.wantTurnRight(car); break;
        }
    }


    private Car createCar(int id, String fromTo) {
        return new Car(id, fromTo);
    }

}
