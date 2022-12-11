package dp.dp01.eggdrop;

class EggDrop3 {

    public static void main(String[] args) {
        int eggs = 2;
        int floor = 100;
        int[][] dp = initDp(eggs, floor);
        int optimalDrop = eggDrop(eggs, floor, dp);
        print(dp);
        System.out.println("optimalDrop = "+ optimalDrop);
    }

    private static int[][] initDp(int eggs, int floor) {
        int[][] dp = new int[eggs+1][floor+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    static int eggDrop(int eggs , int floor, int[][] dp){
        if(dp[eggs][floor]!= -1) {
            return dp[eggs][floor];
        }
        else if(eggs==1) {
            dp[eggs][floor] = floor;
        }
        else if(floor<=1){
            dp[eggs][floor] = 1;
        }else{
            int res = Integer.MAX_VALUE;
            for (int i = 1; i <= floor; i++) {
                res = Math.min(res, Math.max(eggDrop(eggs - 1, i-1, dp), eggDrop(eggs, floor-i, dp)) + 1);
            }
            dp[eggs][floor] = res;
        }

        return dp[eggs][floor];
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
