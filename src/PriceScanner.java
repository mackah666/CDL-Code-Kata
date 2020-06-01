import com.rightcode.Catalog;
import com.rightcode.Sku;

import java.util.List;
import java.util.stream.Collectors;

public class PriceScanner {

    private Catalog catalog;

    public PriceScanner(Catalog catalog) {
        this.catalog = catalog;
    }

    private String getItemsBySkuScancode(Character skuScanCode, String itemList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemList.length(); i++) {
            if (skuScanCode == itemList.charAt(i)) {
                sb.append((Character.toString(itemList.charAt(i))));
            }
        }
        return sb.toString();
    }


    public int getTotalCostItemsInCart(String items) {
        int totalCost = 0;
        int qualifyingDiscountAmount = 3;
        String numberOfItemsBySku;
        for (Sku sku: catalog.getSkuList()) {
            numberOfItemsBySku = getItemsBySkuScancode(sku.getScanCode(), items);
            if (numberOfItemsBySku == null || numberOfItemsBySku.isEmpty()) {
                return totalCost;
            }
            else{
                int discountQualifiers = numberOfItemsBySku.length() / qualifyingDiscountAmount;
                int nonDiscountQualifier = numberOfItemsBySku.length() % qualifyingDiscountAmount;
                if (numberOfItemsBySku.length() >= 3) {
                    return totalCost = (discountQualifiers * ((qualifyingDiscountAmount * 50) - 20))
                            + (nonDiscountQualifier * 50);
                } else {
                    return totalCost = nonDiscountQualifier * 50;

                }
            }
        }
        return totalCost;
    }

}
