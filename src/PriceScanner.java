public class PriceScanner {
    public int getTotalCostItemsInCart(String items){
        //return 0;
        int totalCost = 0;
        int numberOfItems = 0;
        if(items == null || items.isEmpty()){
            return totalCost;
        }else {
            numberOfItems = items.length();
            if(numberOfItems == 3){
                return totalCost = (numberOfItems * 50) - 20;
            } else {
                return totalCost = numberOfItems * 50;

            }
        }
    }
}
