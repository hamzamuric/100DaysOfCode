package hundreddaysofcode.template_method;

public class VeggieHoagie extends Hoagie {

    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    boolean customerWantsMeat() {
        return false;
    }

    @Override
    boolean customerWantsCheese() {
        return false;
    }

    @Override
    void addMeat() { }

    @Override
    void addCheese() { }

    @Override
    void addVegetables() {
        System.out.print("Adding the vegetables: ");
        for (String veggie : veggiesUsed) {
            System.out.print(veggie + " ");
        }
        System.out.println();
    }

    @Override
    void addCondiments() {
        System.out.print("Adding the condiments: ");
        for (String condiment : condimentsUsed) {
            System.out.print(condiment + " ");
        }
        System.out.println();
    }
}
