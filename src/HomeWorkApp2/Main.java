package HomeWorkApp2;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            int[][] result = function(array);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static int[][] function(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (checkArraySize(array)) {
            int[][] result = new int[4][4];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    try {
                        int currentInt = Integer.parseInt(array[i][j]);
                        result[i][j] = currentInt;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("В ячейке [" + i + ":" + j +"] лежит не число");
                    }
                }
            }
            return result;
        }
        else {
            throw new MyArraySizeException("Размер массива должен быть 4 на 4");
        }
    }

    public static boolean checkArraySize(String[][] array) {
        return array.length == 4 && array[0].length == 4;
    }
}
