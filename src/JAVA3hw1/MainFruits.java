package JAVA3hw1;

import com.sun.org.apache.xpath.internal.operations.Or;

public class MainFruits {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple());
        anotherAppleBox.addFruit(new Apple());
        anotherAppleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(anotherAppleBox));

        System.out.println(anotherAppleBox.getWeight());
        appleBox.moveFruits(anotherAppleBox);
        System.out.println(anotherAppleBox.getWeight());
        System.out.println(appleBox.getWeight());

        appleBox.addFruit(new Apple());
        System.out.println(appleBox.getWeight());
    }
}
