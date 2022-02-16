package JAVA3hw1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> listOfFruits;

    public Box() {
        this.listOfFruits = new ArrayList<>();
    }

    public float getWeight(){

        float res = 0f;
        for (int i = 0; i < listOfFruits.size(); i++) {
            res += listOfFruits.get(i).getWeight();
        }
        return res;
    }

    public boolean compare(Box anotherBox){
        return getWeight() == anotherBox.getWeight();
    }

    public void moveFruits(Box<T> anotherBox) {
        anotherBox.listOfFruits.addAll(listOfFruits);
        listOfFruits.clear();
    }

    public void addFruit(T fruit){
        listOfFruits.add(fruit);
    }
}