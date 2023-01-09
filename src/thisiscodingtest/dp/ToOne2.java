package thisiscodingtest.dp;

import java.util.Arrays;

class ToOne2 {
    public static void main(String[] args) {
        int[] modNums = {5, 3, 2};
        System.out.println(toOne(26, modNums));

    }
    static int toOne(int n, int[] modNums){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        dp[n]=1;
        for (int i = dp.length-2; i >=1; i--) {
            dp[i] = Math.min(dp[i+1]+1, dp[i]);
            for (int j = 0; j < modNums.length; j++) {
                if(i%modNums[j] == 0 && i/modNums[j] > 1){
                    dp[i/modNums[j]] = Math.min(dp[i/modNums[j]], dp[i] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[1];
    }
}
