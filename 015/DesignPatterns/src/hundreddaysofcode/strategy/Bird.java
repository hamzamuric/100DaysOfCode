package hundreddaysofcode.strategy;

public class Bird extends Animal {

    public Bird() {
        setSound("Tweet");
        flyingType = new ItFlys();
    }
}
