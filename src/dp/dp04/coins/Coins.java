package dp.dp04.coins;

class Coins {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int money = 5;
        coins(money, coins);
    }
    static void coins(int money, int[] coins){
        int[][] dp = new int[coins.length+1][money+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= money; j++) {
                if(j-coins[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
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
