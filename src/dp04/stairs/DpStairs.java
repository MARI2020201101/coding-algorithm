package dp04.stairs;

class DpStairs {
    public static void main(String[] args) {
        countWays(4,2);
    }
    static int countWays(int stairs, int jump){
        int[][] dp = new int[jump+1][stairs+1];
        dp[0][0]=1;
        for (int i = 1; i < dp.length; i++) {
            int jumps = i;
            for (int j = 1; j < dp[0].length; j++) {
                if(dp[i-1][j] > 0){
                    dp[i][j] = dp[i-1][j];
                }
                if(j%jumps==0){
                    dp[i][j]+=1;
                }
            }
        }
        print(dp);
        return dp[jump][stairs];
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
