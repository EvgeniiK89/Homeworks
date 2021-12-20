package HomeWorkApp1;

public class Human implements Action{

    @Override
    public void run() {
        System.out.println("Human run");
    }

    @Override
    public void jump() {
        System.out.println("Human jump");
    }

    @Override
    public String getName() {
        return "Human";
    }
}
