import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDLKataTests {

    PriceScanner priceScanner;
    @BeforeEach
    void SetUp(){
        priceScanner = new PriceScanner();
    }

    @Test
    public void EmptyCheckoutShouldCost0(){
        String items = "";
        assertEquals(0, priceScanner.getTotalCostItemsInCart(items));
    }

    @Test
    public void OneAItemShouldCost50(){
        String items = "A";
        assertEquals(50, priceScanner.getTotalCostItemsInCart(items));
    }
    @Test
    public void TwoAItemShouldCost100(){
        String items = "AA";
        assertEquals(100, priceScanner.getTotalCostItemsInCart(items));
    }

}
