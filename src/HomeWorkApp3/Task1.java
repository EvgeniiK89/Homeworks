package HomeWorkApp3;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        ArrayList <String> words = new ArrayList<>(Arrays.asList("Apple", "Samsung", "Xiaomi", "Huawei", "NOKIA", "Apple", "Huawei"));
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String str : words) {
            uniqueWords.add(str);
        }
        for (String str : uniqueWords) {
            System.out.println(str);
        }

        for (String uniqueWord : uniqueWords) {
            int counterWords = 0;
            for (String curWord : words) {
                if (uniqueWord.equals(curWord)) {
                    counterWords++;
                }
            }
            System.out.println(uniqueWord + " repeats " + counterWords);
        }
    }
}
