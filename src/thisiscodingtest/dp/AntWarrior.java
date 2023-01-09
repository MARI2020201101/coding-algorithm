package thisiscodingtest.dp;

class AntWarrior {
    public static void main(String[] args) {
        int[] arr = {1,3,1,5};
        System.out.println(solve(arr));
    }
   static int solve(int[] arr){
       int[] dp = new int[arr.length];
       dp[0] = arr[0];
       dp[1] = arr[1];
       for (int i = 2; i < arr.length; i++) {
           dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
       }
       return dp[dp.length-1];
   }

}
