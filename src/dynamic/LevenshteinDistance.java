package dynamic;

class LevenshteinDistance {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("carthorse", "orchestra"));
    }
    static int levenshteinDistance(String A, String B){
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1 ; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(A.charAt(i)==B.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        print(dp);
        return dp[A.length()-1][B.length()-1];
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
