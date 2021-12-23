package HomeWorkApp1;

public class Wall implements Obstacle {

    @Override
    public boolean overcome(Action action) {
        double decision = Math.random();
        if (decision > 0.1) {
            System.out.println(action.getName() + " successfully jumped");
            return true;
        } else {
            System.out.println(action.getName() + " unsuccessfully jumped");
            return false;
        }
    }
}