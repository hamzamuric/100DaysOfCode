package hundreddaysofcode.template_method;

public abstract class Hoagie {

    final void makeSandwich() {
        cutBun();

        if (customerWantsMeat()) {
            addMeat();
        }

        if (customerWantsCheese()) {
            addCheese();
        }

        if (customerWantsVegetables()) {
            addVegetables();
        }

        if (customerWantsCondiments()) {
            addCondiments();
        }

        wrapTheHoagie();
    }

    public void cutBun() {
        System.out.println("The hoagie is cut");
    }

    public void wrapTheHoagie() {
        System.out.println("Wrap the hoagie");
    }

    abstract void addMeat();

    abstract void addCheese();

    abstract void addVegetables();

    abstract void addCondiments();

    boolean customerWantsMeat() {
        return true;
    }

    boolean customerWantsCheese() {
        return true;
    }

    boolean customerWantsVegetables() {
        return true;
    }

    boolean customerWantsCondiments() {
        return true;
    }
}
