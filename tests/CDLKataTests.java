import com.rightcode.Catalog;
import com.rightcode.DiscountRule;
import com.rightcode.Sku;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDLKataTests {

    PriceScanner priceScanner;
    Catalog catalog;
    @BeforeEach
    void SetUp(){
        catalog = new Catalog();
        catalog.AddToCatalog(new Sku('A', 50, new DiscountRule(20, 3)));
        catalog.AddToCatalog(new Sku('B', 30, new DiscountRule(15, 2)));
        catalog.AddToCatalog(new Sku('C', 20, new DiscountRule(0,0)));
        catalog.AddToCatalog(new Sku('D', 15, new DiscountRule(0,0)));
        priceScanner = new PriceScanner(catalog);

    }

    @Test
    @Order(1)
    public void EmptyCheckoutShouldCost0(){
        String items = "";
        assertEquals(0, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(2)
    @Test
    public void OneAItemShouldCost50(){
        String items = "A";
        assertEquals(50, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(3)
    @Test
    public void TwoAItemShouldCost100(){
        String items = "AA";
        assertEquals(100, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(4)
    @Test
    public void ThreeAItemShouldCost130AfterDiscount(){
        String items = "AAA";
        assertEquals(130, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(5)
    @Test
    public void FourAItemShouldCost180AfterDiscount(){
        String items = "AAAA";
        assertEquals(180, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(5)
    @Test
    public void SevenAItemShouldCost310AfterDiscount(){
        String items = "AAAAAAA";
        assertEquals(310, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(6)
    @Test
    public void OneBItemShouldCost30(){
        String items = "B";
        assertEquals(30, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(7)
    @Test
    public void OneCItemShouldCost20(){
        String items = "C";
        assertEquals(20, priceScanner.getTotalCostItemsInCart(items));
    }
    @Order(8)
    @Test
    public void OneDItemShouldCost15(){
        String items = "D";
        assertEquals(15, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(9)
    @Test
    public void OneDItemShouldCost245(){
        String items = "AAABBCCDD";
        assertEquals(245, priceScanner.getTotalCostItemsInCart(items));
    }

    @Order(10)
    @Test
    public void OneDItemShouldCost325(){
        String items = "AAAABBBCCDD";
        assertEquals(325, priceScanner.getTotalCostItemsInCart(items));
    }

}
