package HomeWorkApp1;

public class Cat implements Action{

    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat jump");
    }

    @Override
    public String getName() {
        return "Cat";
    }
}
