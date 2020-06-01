import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDLKataTests {

    PriceScanner priceScanner;
    @BeforeEach
    void SetUp(){
        priceScanner = new PriceScanner();
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

}
