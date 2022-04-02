package com.lpf.traffic.light.model1;

import com.lpf.traffic.light.Car;
import com.lpf.traffic.light.DirectionConstant;
import com.lpf.traffic.light.turn.TurnControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/** 随机车辆生成器
 * @author liupf
 */
public class CarGenerator extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(CarGenerator.class);
    /** 北 东 南 西
     *
     *  左  直  右
     */
    private static final String[][] fromToInfos = new String[][]{{"from 北 to 东", "from 北 to 南", "from 北 to 西"},
            {"from 东 to 南", "from 东 to 西", "from 东 to 北"},
            {"from 南 to 西", "from 南 to 北", "from 南 to 东"},
            {"from 西 to 北", "from 西 to 东", "from 西 to 南"}};


    private AtomicInteger idGenerator;

    private TurnControl northTurnControl;

    private TurnControl southTurnControl;

    private TurnControl eastTurnControl;

    private TurnControl westTurnControl;


    public CarGenerator(TurnControl northTurnControl, TurnControl southTurnControl, TurnControl eastTurnControl, TurnControl westTurnControl) {
        super("CarGenerator Thread");
        idGenerator = new AtomicInteger(0);

        this.northTurnControl = northTurnControl;
        this.southTurnControl = southTurnControl;
        this.eastTurnControl = eastTurnControl;
        this.westTurnControl = westTurnControl;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));

                createRandomCarToRoad();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void createRandomCarToRoad() {
        int roadIndex = ThreadLocalRandom.current().nextInt(4);
        int directionIndex = ThreadLocalRandom.current().nextInt(3);

        Car car = createCar(roadIndex, directionIndex);

        LOGGER.debug("生产车辆：{}", car);

        TurnControl turnControl = null;
        switch (roadIndex) {
            case DirectionConstant.NORTH : turnControl = northTurnControl; break;
            case DirectionConstant.EAST : turnControl = eastTurnControl; break;
            case DirectionConstant.SOUTH : turnControl = southTurnControl; break;
            case DirectionConstant.WEST : turnControl = westTurnControl; break;
        }

        carToRoad(car, turnControl, directionIndex);
    }

    private void carToRoad(Car car, TurnControl turnControl, int directionIndex) {
        switch (directionIndex) {
            case DirectionConstant.LEFT : turnControl.wantTurnLeft(car); break;
            case DirectionConstant.STRAIGHT : turnControl.wantStraight(car); break;
            case DirectionConstant.RIGHT : turnControl.wantTurnRight(car); break;
        }
    }


    private Car createCar(int roadIndex, int direction) {
        return new Car(idGenerator.addAndGet(1), fromToInfos[roadIndex][direction], direction);
    }

}
