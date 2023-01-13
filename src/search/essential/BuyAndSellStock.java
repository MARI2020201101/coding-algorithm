package search.essential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BuyAndSellStock {
    static double buyAndSellKTimes(List<Double> prices,int k){
        List<Double> minPrices = new ArrayList<>(Collections.nCopies(k, Double.MAX_VALUE));
        List<Double> maxProfits = new ArrayList<>(Collections.nCopies(k, 0.0));
        for (Double price : prices){
            for (int i = k-1; i >=0 ; i--) {
                maxProfits.set(i, Math.max(maxProfits.get(i), price - minPrices.get(i)));
                minPrices.set(i, Math.min(minPrices.get(i), price - (i>0? maxProfits.get(i-1) : 0.0)));
            }
        }
        return maxProfits.get(maxProfits.size()-1);
    }
}
