import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDLKataTests {


    @Test
    public void EmptyCheckoutShouldCost0(){
        String items = "";
        PriceScanner scanner = new PriceScanner();
        assertEquals(0, scanner.getTotalCostItemsInCart(items));
    }

}
