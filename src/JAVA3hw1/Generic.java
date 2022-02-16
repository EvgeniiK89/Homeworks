package JAVA3hw1;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    private T[] arr;

    public Generic(T[] arr) {
        this.arr = arr;
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    public List<T> convertToArrayList(T[] arr) {

        List<T> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }
}


