package HomeWorkApp1;

public class Robot implements Action{
    @Override
    public void run() {
        System.out.println("Robot run");
    }

    @Override
    public void jump() {
        System.out.println("Robot jump");
    }

    @Override
    public String getName() {
        return "Robot";
    }
}
