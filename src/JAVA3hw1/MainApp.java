package JAVA3hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

    }
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static void replaceElements (Object[] arr, int a1, int a2) {

        if (a1 >= 0 && a1 < arr.length && a2 >= 0 && a2 < arr.length) {
            Object repl = arr[a1];
            arr[a1] = arr[a2];
            arr[a2] = repl;
        }
    }
}

