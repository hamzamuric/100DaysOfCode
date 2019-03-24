package hundreddaysofcode.factory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;


        Scanner input = new Scanner(System.in);

        System.out.print("What type of ship? (U / R / B): ");
        if (input.hasNextLine()) {
            String typeOfShip = input.nextLine();
            theEnemy = shipFactory.makeEnemyShip(typeOfShip);
        }

        if (theEnemy != null) {
            doStuffEnemy(theEnemy);
        } else {
            System.out.println("Enter U, R of B next time.");
        }

    }

    public static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
