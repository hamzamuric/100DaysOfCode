package hundreddaysofcode.adapter;

import java.util.Random;

public class EnemyRobot {

    private Random generator = new Random();

    public void smashWithHands() {
        int attackDamage = generator.nextInt(10) + 1;
        System.out.println("Enemy Robot causes " + attackDamage + " damage with it's hands");
    }

    public void walkForward() {
        int movement = generator.nextInt(5) + 1;
        System.out.println("Enemy Robot walks forward " + movement + " spaces");
    }

    public void reactToHuman(String driverName) {
        System.out.println("Enemy Robot tramps on " + driverName);
    }
}
