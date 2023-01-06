package dynamic;

import java.util.Arrays;

class NumCombinationsForFinalScore {
    public static void main(String[] args) {
        int[] scores = {2,3,7};
        System.out.println(numCombinationsForFinalScore(12, scores));
    }
    static int numCombinationsForFinalScore(int finalScore, int[] scores){
        int[] dp = new int[finalScore+1];
        dp[0] = 1;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(j - scores[i] >= 0 && dp[j-scores[i]] >= 1){
                    dp[j] = Math.max(dp[j], dp[j-scores[i]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[finalScore];
    }
}
