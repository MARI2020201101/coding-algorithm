package thisiscodingtest.dp;

import org.w3c.dom.ls.LSOutput;

class WayOfTiles {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }
    static int solve(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = 2*dp[i-2] + dp[i-1] ;
        }
        return dp[N];
    }
}
