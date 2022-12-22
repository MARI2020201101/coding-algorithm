package basis.dp.dp01.eggdrop;

class EggDrop2 {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int egg = 2;
        int floor = 100;
        int[][] dp = new int[egg+1][floor+1];
        new EggDrop2().init(dp);
        System.out.println(eggDrop(egg, floor, dp));
    }
    void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
    }
    static int eggDrop(int egg, int floor, int[][] dp){
        if(floor <= 1) return 1;
        if(egg == 1) return floor;

        if(dp[egg][floor]!=Integer.MAX_VALUE) return dp[egg][floor];

        for (int i = 1; i <= floor; i++) {
            dp[egg][floor] = Math.min(dp[egg][i],
            eggDrop(egg-1,i-1, dp) + eggDrop(egg, floor-i,dp))+1;
        }
        return dp[egg][floor];
    }
}
