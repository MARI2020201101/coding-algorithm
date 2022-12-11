package dp.dp04.rob;

import java.util.Arrays;

class Rob2 {
    static int[] house = {2,1,7,9,3,1};

    public static void main(String[] args) {
        System.out.println(maxRob(house));
    }
    static int maxRob(int[] house){
        int[] dp = new int[house.length+2];
        for (int i = house.length-1; i >=0 ; i--) {
            dp[i] = Math.max(dp[i+2]+house[i], dp[i+1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
