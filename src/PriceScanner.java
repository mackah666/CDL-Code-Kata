public class PriceScanner {
    public int getTotalCostItemsInCart(String items){
        //return 0;
        int totalCost = 0;
        int qualifyingDiscountAmount = 3;
        int numberOfItems = 0;
        if(items == null || items.isEmpty()){
            return totalCost;
        }else {
            numberOfItems = items.length();
            int discountQualifiers = numberOfItems / qualifyingDiscountAmount;
            int nonDiscountQualifier = numberOfItems % qualifyingDiscountAmount;

            if(numberOfItems >= 3){
                return totalCost = (discountQualifiers * ((qualifyingDiscountAmount * 50) - 20))
                        + (nonDiscountQualifier * 50);
            } else {
                return totalCost = numberOfItems * 50;

            }
        }
    }
}
