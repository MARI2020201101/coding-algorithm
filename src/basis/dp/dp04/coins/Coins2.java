package basis.dp.dp04.coins;

import java.util.Arrays;

class Coins2 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int money = 5;
        coins(money, coins);
    }
    static void coins(int money, int[] coins){
        int[] dp = new int[money+1];
        for (int i = 0; i < dp.length; i++) {
            dp[0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= money; j++) {
                if(j-coins[i]>=0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }else{
                    dp[j] = dp[j];
                }
        }
        }
        System.out.println(Arrays.toString(dp));
    }
}
