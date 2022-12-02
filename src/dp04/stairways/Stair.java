package dp04.stairways;

class Stair {
    public static void main(String[] args) {
        stairs(5,2);
    }
    static void stairs(int stairs, int jumps){
        int[][] dp = new int[jumps+1][stairs+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j-i>=0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-i];
                }else{
                    dp[i][j]=dp[i-1][j];
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
