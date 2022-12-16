package search.binary.shipwithindays;

import java.util.Arrays;

class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights,5));
    }
    static int shipWithinDays(int[] weights, int D){
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left < right){
           int mid = left + ((right-left)/2);
           if(canShip(weights, mid, D)){
               right = mid;
           }else{
               left = mid+1;
           }
        }
        return left;
    }

    private static boolean canShip(int[] weights, int mid, int days) {
        int i=0;
        for (int day = 0; day < days; day++) {
            int limit = mid;
            while(i<weights.length && limit - weights[i] >= 0) {
                    limit -= weights[i++];
            }
        }
        return i==weights.length;
    }
}
