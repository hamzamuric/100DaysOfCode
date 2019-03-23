package hundreddaysofcode.strategy;

public class Dog extends Animal {

    public void digHole() {
        System.out.println("Dug a hole.");
    }

    public Dog() {
        setSound("Bark");
        flyingType = new CantFly();
    }


}
