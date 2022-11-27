package dp02.numberofways;

class NumberOfWays2 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(4,4));
    }
    static int numberOfWays(int n, int m){
        int[][] dp = new int[n + m + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        return __numberOfWays(n+m, m ,dp);
    }

    private static int __numberOfWays(int n, int m, int[][] dp) {
        if(dp[n][m]!=-1) return dp[n][m];
        if(n<m) {
            dp[n][m]=0;
        }
        else if(n<=1) {
            dp[n][m]=1;
        }
        else if(n>m && m==1) {
            dp[n][m]=n;
        }
        else{
            dp[n][m] = __numberOfWays(n-1, m, dp) + __numberOfWays(n-1,m-1, dp);
        }
        return dp[n][m];
    }
}
