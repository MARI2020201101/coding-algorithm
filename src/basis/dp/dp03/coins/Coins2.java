package basis.dp.dp03.coins;

import java.util.Arrays;

class Coins2 {
    public static void main(String[] args) {
        int money = 6;
        int[] coins = {1,3,4};
        System.out.println(minCoins(money,coins));
        System.out.println(minCoins(10,coins));
    }
    static int minCoins(int money, int[] coins){
        int[] dp = new int[money+1];
        Arrays.setAll(dp, (a)->Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
