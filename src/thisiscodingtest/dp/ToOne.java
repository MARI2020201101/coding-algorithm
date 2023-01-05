package thisiscodingtest.dp;

class ToOne {
    public static void main(String[] args) {
        System.out.println(toOne(26));
    }
    static int toOne(int n){
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n] = 1;
        for (int i = dp.length-2; i >=1 ; i--) {
            if(i%5==0){
                dp[i/5] = Math.min(dp[i]+1, dp[i/5]);
            }
            if(i%3==0){
                dp[i/3] = Math.min(dp[i]+1, dp[i/3]);
            }
            if(i%2==0){
                dp[i/2] = Math.min(dp[i]+1, dp[i/2]);
            }

            dp[i-1] = Math.min(dp[i]+1, dp[i-1]);


        }
        return dp[1];
    }
}
