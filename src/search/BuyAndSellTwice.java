package search;

import java.util.ArrayList;
import java.util.List;

class BuyAndSellTwice {
    public static void main(String[] args) {
        List<Double> prices = new ArrayList<>();
        prices.add(12.0);
        prices.add(11.0);
        prices.add(13.0);
        prices.add(9.0);
        prices.add(12.0);
        prices.add(8.0);
        prices.add(14.0);
        prices.add(13.0);
        prices.add(15.0);
        System.out.println(buyAndSellTwice(prices));
    }
    static Double buyAndSellTwice(List<Double> prices){
        Double maxProfit = 0.0;
        Double minPriceSoFar = Double.MAX_VALUE;
        List<Double> firstBuySellStocks = new ArrayList<>();
        firstBuySellStocks.add(prices.get(0));
        for (int i = 0; i < prices.size(); i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i) - minPriceSoFar);
            firstBuySellStocks.add(maxProfit);
        }
        Double maxPriceSoFar = Double.MIN_VALUE;
        for (int i = prices.size()-1; i > 0 ; i--) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices.get(i) + firstBuySellStocks.get(i-1));
        }
        return maxProfit;
    }
}
