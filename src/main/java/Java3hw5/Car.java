package Java3hw5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static Java3hw5.MainClass.countDownLatchRacersStart;
import static Java3hw5.MainClass.finish;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch countDownLatchReady = countDownLatchRacersStart;;
    private static CountDownLatch countDownLatchFinish = MainClass.countDownLatchRacersFinish;
    private static CyclicBarrier cyclicBarrier = MainClass.barrier;


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            countDownLatchReady.countDown();
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finish(this.name);
        countDownLatchFinish.countDown();
    }
}
