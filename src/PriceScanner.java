public class PriceScanner {
    public int getTotalCostItemsInCart(String items){
        //return 0;
        int totalCost = 0;
        int numberOfItems = 0;
        if(items == null || items.isEmpty()){
            return totalCost;
        }else {
            numberOfItems = items.length();
            totalCost = numberOfItems * 50;
            return totalCost;
        }
    }
}
