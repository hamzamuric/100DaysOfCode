package hundreddaysofcode.prototype;

public class Sheep implements Animal {

    {
        System.out.println("Sheep is made");
    }

    @Override
    public Animal makeCopy() {
        System.out.println("Sheep is being made");

        Sheep sheepObject = null;

        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sheepObject;
    }

    @Override
    public String toString() {
        return "I am a sheep, Baaaaa";
    }
}
