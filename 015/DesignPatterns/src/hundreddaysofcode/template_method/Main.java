package hundreddaysofcode.template_method;

public class Main {

    public static void main(String[] args) {

        Hoagie cust12Hoagie = new ItalianHoagie();
        cust12Hoagie.makeSandwich();

        Hoagie cust13Hoagie = new VeggieHoagie();
        cust13Hoagie.makeSandwich();

    }
}
