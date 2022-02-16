package JAVA3hw1;

public abstract class Fruit {

    public Fruit(float weight) {
        this.weight = weight;
    }

    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
