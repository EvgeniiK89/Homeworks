package Java3hw5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    static CountDownLatch countDownLatchRacersStart = new CountDownLatch(CARS_COUNT);
    static CountDownLatch countDownLatchRacersFinish = new CountDownLatch(CARS_COUNT);
    static CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    static volatile Boolean finish;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            countDownLatchRacersStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            countDownLatchRacersFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void finish(String name) {
        if (finish == null) {
            System.out.println(name + " - WIN");
            finish = true;
        }
    }
}
