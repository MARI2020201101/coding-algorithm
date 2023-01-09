package thisiscodingtest.dp;

import java.util.Arrays;

class MakeMoney {
    public static void main(String[] args) {
        int[] coins = {2,3};
        System.out.println(solve(coins, 15));
    }
    static int solve(int[] coins, int money){
        int[] dp = new int[money+1];
        Arrays.fill(dp, 99999);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length && i+coins[j] < dp.length ; j++) {
                dp[i+coins[j]] = Math.min(dp[i+coins[j]], dp[i] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[money];
    }
}
