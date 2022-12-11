package dp.dp04.maxcoins;

class MaxCoins {
    static int[] coins = {10,25,5,1,10,5};

    public static void main(String[] args) {
        int[][] dp = new int[coins.length][coins.length];
        initDp(dp);
        maxCoins(coins, 0, coins.length-1, dp);
        print(dp);
    }
    static void initDp(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    static int maxCoins(int[] coins, int left, int right, int[][] dp){
        if(right>coins.length-1 || left > right){
            return 0;
        }
        else if(dp[left][right]!=-1){
            return dp[left][right];
        }
        else{
            int selectL = Math.min(coins[left] + maxCoins(coins, left+1, right-1, dp)
                                , coins[left] + maxCoins(coins, left+2, right, dp));
            int selectR = Math.min(coins[right] + maxCoins(coins, left+1, right-1, dp)
                                , coins[right] + maxCoins(coins, left, right-2, dp));
            dp[left][right] = Math.max(selectL,selectR);
            return dp[left][right];
        }
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
