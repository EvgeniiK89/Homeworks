package HomeWorkApp1;

public class Main {

    public static void main(String[] args) {
        Action[] players = new Action[3];
        players[0] = new Cat();
        players[1] = new Human();
        players[2] = new Robot();

        Obstacle[] obstacles = new Obstacle[5];
        for (int i = 0; i < obstacles.length; i++) {
            if (Math.random() >= 0.5) {
                obstacles[i] = new Wall();
            } else {
                obstacles[i] = new RunningRoad();
            }
        }

        for (int i = 0; i < players.length; i++) {
            Action player = players[i];
            boolean isStopped = false;
            for (int j = 0; j < obstacles.length; j++) {
                Obstacle obstacle = obstacles[j];
                if (!obstacle.overcome(player)) {
                    System.out.println(player.getName() + " can't finish");
                    isStopped = true;
                    break;
                }
            }
            if (!isStopped) {
                System.out.println(player.getName() + " finished!");
            }
        }
    }
}
