package Java3hw5;

import java.util.concurrent.Semaphore;

import static Java3hw5.MainClass.CARS_COUNT;

public class Tunnel extends Stage {
    private static Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(c.getName() + " закончил этап: " + description);
        }
    }
}
