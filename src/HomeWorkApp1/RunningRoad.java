package HomeWorkApp1;

public class RunningRoad implements Obstacle {
    @Override
    public boolean overcome(Action action) {
        double decision = Math.random();
        if(decision > 0.05) {
            System.out.println(action.getName() + " successfully run");
            return true;
        }
        else {
            System.out.println(action.getName() + " unsuccessfully run");
            return false;
        }
    }
}
