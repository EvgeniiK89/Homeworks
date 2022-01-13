package HomeWorkApp5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        nonThread(initialize());
        multiThread(initialize());
    }

    private static void nonThread(float[] arr) {
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    private static float[] initialize() {
        float[] result = new float[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        return result;
    }

    public static void multiThread(float[] fl) {

        long startTime = System.currentTimeMillis();
        Calculate calculateThreadLeft = new Calculate(fl, Arrays.copyOfRange(fl, 0, h), 0, h);
        Calculate calculateThreadRight = new Calculate(fl, Arrays.copyOfRange(fl, h, fl.length), h, h);

        calculateThreadLeft.start();
        calculateThreadRight.start();

        try {
            calculateThreadLeft.join();
            calculateThreadRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
