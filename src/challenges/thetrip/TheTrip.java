package challenges.thetrip;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

class TheTrip {
    public static void main(String[] args) {
        double[] arr = {15.00, 15.01, 3.00, 3.01};
        System.out.println(solve(arr));
    }
    static BigDecimal solve(double[] arr){
        Arrays.sort(arr);
        BigDecimal discount = new BigDecimal("0");
        BigDecimal aver = new BigDecimal("0");
        for (int i = 0; i < arr.length; i++) {
            double v = arr[i];
            aver = aver.add(BigDecimal.valueOf(v));
        }
        aver=aver.divide(BigDecimal.valueOf(arr.length));
        System.out.println("aver = "+aver);

        for (int i = 0; i < arr.length; i++) {
            BigDecimal v = BigDecimal.valueOf(arr[i]);
            if(aver.compareTo(v) < 0){
                discount = discount.add(v.subtract(aver));
            }
        }
        return discount;
    }
}
