package hundreddaysofcode.factory;

public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(String newShipName) {
        switch (newShipName) {
            case "U":
                return new UFOEnemyShip();
            case "R":
                return new RocketEnemyShip();
            case "B":
                return new BigUFOEnemyShip();
            default:
                return null;
        }
    }

}
