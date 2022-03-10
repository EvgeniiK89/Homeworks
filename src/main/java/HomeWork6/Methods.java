package HomeWork6;

public class Methods {
    public int[] foo(int[] array) {
        int index = findLastIndex4(array);
        int[] result = new int[array.length - index - 1];
        int j = 0;
        for (int i = index + 1; i < array.length; i++) {
            result[j++] = array[i];
        }
        return result;
    }

    public boolean f(int [] array) {
        return (findNumber(1, array) && findNumber(4, array));
    }

    private boolean findNumber(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    private int findLastIndex4(int[] array) {
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndex = i;
            }
        }
        if (lastIndex == -1) {
            throw new RuntimeException("no 4 found!");
        }
        return lastIndex;
    }

}
