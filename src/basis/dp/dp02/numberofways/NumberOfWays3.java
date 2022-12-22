package basis.dp.dp02.numberofways;

class NumberOfWays3 {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] dp = new int[n + m + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(numberOfWays(n,m, dp));
        print(dp);
    }
    static int numberOfWays(int n, int m , int[][] dp) {

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
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
