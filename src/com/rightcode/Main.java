import com.rightcode.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world!");
        Catalog catalog = new Catalog();
        catalog.AddToCatalog(new Sku('A', 50, new DiscountRule(20, 3)));
        catalog.AddToCatalog(new Sku('B', 30, new DiscountRule(15, 2)));
        catalog.AddToCatalog(new Sku('C', 20, new DiscountRule(0,0)));
        catalog.AddToCatalog(new Sku('D', 15, new DiscountRule(0,0)));

        IPriceScanner scanner;
        scanner = new PriceScanner(catalog);

    }
}
