package HomeWorkApp5;

public class Calculate extends Thread {

    private float[] sourceArray;
    private float[] subArray;
    private int start;
    private int size;

    public Calculate(float[] sourceArray, float[] subArray, int start, int size) {
        this.sourceArray = sourceArray;
        this.subArray = subArray;
        this.start = start;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = (float)(subArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(subArray, 0, sourceArray, start, size);
    }
}
