package hundreddaysofcode.abstract_factory;

public abstract class EnemyShip {

    private String name;

    // Newly defined objects that represent weapon & engine
    // These can be changed easily by assigning new parts
    // in UFOEnemyShipFactory or UFOBossEnemyShipFactory

    ESWeapon weapon;
    ESEngine engine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void makeShip();

    // Because I defined the toString method in engine
    // when it is printed the String defined in toString goes
    // on the screen

    public void followHeroShip() {
        System.out.println(name + " is following the hero at " + engine);
    }

    public void displayEnemyShip() {
        System.out.println(name + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(name + " attacks and does " + weapon);
    }

    // If any EnemyShip object is printed to screen this shows up

    public String toString() {
        return "The " + name + " has a top speed of " + engine + " and an attack power of " + weapon;
    }
}
