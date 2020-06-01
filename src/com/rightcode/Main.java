import com.rightcode.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter quit to exit");
        System.out.println("Items Available are A, B, C, D");
        IPriceScanner priceScanner = getPriceScanner();
        Scanner inputScanner = new Scanner(System.in);
        String input = new String();
        int runningTotal = 0;

        while(inputScanner.hasNextLine() && !((input = inputScanner.nextLine()).equals("exit"))) {
            runningTotal = runningTotal + priceScanner.getTotalCostItemsInCart(input);
            System.out.println(runningTotal);
        }
    }

    private static IPriceScanner getPriceScanner() {
        Catalog catalog = new Catalog();
        catalog.AddToCatalog(new Sku('A', 50, new DiscountRule(20, 3)));
        catalog.AddToCatalog(new Sku('B', 30, new DiscountRule(15, 2)));
        catalog.AddToCatalog(new Sku('C', 20, new DiscountRule(0,0)));
        catalog.AddToCatalog(new Sku('D', 15, new DiscountRule(0,0)));
        return new PriceScanner(catalog);
    }
}
