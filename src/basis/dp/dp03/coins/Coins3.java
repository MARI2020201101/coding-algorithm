package basis.dp.dp03.coins;

import java.util.Arrays;

class Coins3 {
    public static void main(String[] args) {
        int money = 10;
        int[] coins = {1,3,4};
        int[] solution = new int[money+1];
        System.out.println(minCoins(money,coins, solution));
        printMinCoins(money,solution);
    }
    static int minCoins(int money, int[] coins, int[] solution){
        int[] dp = new int[money+1];
        Arrays.setAll(dp, (a)->Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0 && dp[i]>=dp[i-coins[j]]+1){
                    dp[i] = dp[i-coins[j]]+1;
                    solution[i] = coins[j];
                }
            }

        }
        System.out.println("basis.dp : "+Arrays.toString(dp));
        System.out.println("basis.solution : "+Arrays.toString(solution));
        return dp[dp.length-1];
    }
    static void printMinCoins(int money, int[] solution){
        while(money>0){
            int coin = solution[money];
            System.out.print(coin + " -> ");
            money-=coin;
        }
    }
}
