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
                int discountQualifiers = getNumberOfDiscountQualifiers(qualifyingDiscountAmount, numberOfItemsBySku);
                int nonDiscountQualifier = getNumberOfNonDiscountQualifiers(qualifyingDiscountAmount, numberOfItemsBySku);
                if (numberOfItemsBySku.length() >= sku.getDiscountRule().getDiscountQuantity()) {
                    totalCost += (discountQualifiers * ((qualifyingDiscountAmount * sku.getPrice()) - sku.getDiscountRule().getDiscountAmount()))
                            + (nonDiscountQualifier * sku.getPrice());
                } else {
                    totalCost += nonDiscountQualifier * sku.getPrice();

                }
            }
        }
        return totalCost;
    }

    private int getNumberOfNonDiscountQualifiers(int qualifyingDiscountAmount, String numberOfItemsBySku) {
        return numberOfItemsBySku.length() % qualifyingDiscountAmount;
    }

    private int getNumberOfDiscountQualifiers(int qualifyingDiscountAmount, String numberOfItemsBySku) {
        return numberOfItemsBySku.length() / qualifyingDiscountAmount;
    }

}
