package hundreddaysofcode.observer;

import java.text.DecimalFormat;

/*
 *  Just for working with threads.
 *  Not so important for Observer pattern itself.
 */
public class GetTheStock implements Runnable {

    private int startTime; // not used
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice) {
        this.stockGrabber = stockGrabber;
        startTime = newStartTime; // not used
        stock = newStock;
        price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000); // startTime can be used here
            } catch (InterruptedException e) {}

            double randomNumber = (Math.random() * .06) - .03;

            DecimalFormat df = new DecimalFormat("#.##");

            price = Double.valueOf(df.format(price + randomNumber));

            if (stock.equals("IBM")) ((StockGrabber) stockGrabber).setIbmPrice(price);
            if (stock.equals("AAPL")) ((StockGrabber) stockGrabber).setAaplPrice(price);
            if (stock.equals("GOOG")) ((StockGrabber) stockGrabber).setGoogPrice(price);

            System.out.println("\n" + stock + ": " + df.format(price /* ? -> */ + randomNumber) +
                    " " + df.format(randomNumber) + "\n");
        }
    }
}
