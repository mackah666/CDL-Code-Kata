import com.rightcode.Catalog;
import com.rightcode.Sku;

import java.util.List;
import java.util.stream.Collectors;

public class PriceScanner implements IPriceScanner {

    private Catalog catalog;

    public PriceScanner(Catalog catalog) {
        this.catalog = catalog;
    }

    private int getItemsBySkuScancode(Character skuScanCode, String itemList) {
        int numberFound = 0;
        for (int i = 0; i < itemList.length(); i++) {
            if (skuScanCode == itemList.charAt(i)) {
                numberFound++;
            }
        }
        return numberFound;
    }

    public int getTotalCostItemsInCart(String items) {
        int totalCost = 0;
        int numberOfItemsBySku;
        for (Sku sku: catalog.getSkuList()) {
            numberOfItemsBySku = getItemsBySkuScancode(sku.getScanCode(), items);
            if(numberOfItemsBySku > 0 && sku.getDiscountRule().getDiscountQuantity() != 0) {
                int discountQualifiers = getNumberOfDiscountQualifiers(sku.getDiscountRule().getDiscountQuantity(), numberOfItemsBySku);
                int nonDiscountQualifier = getNumberOfNonDiscountQualifiers(sku.getDiscountRule().getDiscountQuantity(), numberOfItemsBySku);
                if (numberOfItemsBySku >= sku.getDiscountRule().getDiscountQuantity()) {
                    totalCost += getDiscoutSubTotalCost(sku.getDiscountRule().getDiscountQuantity(), sku, discountQualifiers, nonDiscountQualifier);
                } else {
                    totalCost += getNonDiscountedSubTotalCost(sku, nonDiscountQualifier);
                }
            }
            else {

                totalCost += sku.getPrice() * numberOfItemsBySku;
            }
        }
        return totalCost;
    }

    private int getNonDiscountedSubTotalCost(Sku sku, int nonDiscountQualifier) {
        return nonDiscountQualifier * sku.getPrice();
    }

    private int getDiscoutSubTotalCost(int qualifyingDiscountAmount, Sku sku, int discountQualifiers, int nonDiscountQualifier) {
        return (discountQualifiers * ((getNonDiscountedSubTotalCost(sku, qualifyingDiscountAmount)) - sku.getDiscountRule().getDiscountAmount()))
                + (getNonDiscountedSubTotalCost(sku, nonDiscountQualifier));
    }

    private int getNumberOfNonDiscountQualifiers(int qualifyingDiscountAmount, int numberOfItemsBySku) {
        return numberOfItemsBySku % qualifyingDiscountAmount;
    }

    private int getNumberOfDiscountQualifiers(int qualifyingDiscountAmount, int numberOfItemsBySku) {
        return numberOfItemsBySku / qualifyingDiscountAmount;
    }

}