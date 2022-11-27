package dp02.finalscore;

class NumOfFinalScore {
    public static void main(String[] args) {
        System.out.println(numOfFinalScore(12));
    }
    static int numOfFinalScore(int n){
        int[][] scores = new int[3][n+1];

        for (int i = 0; i < scores[0].length; i+=2) {
            scores[0][i] = 1;
        }
        for (int i = 1; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                if(scores[i-1][j]>0){
                    scores[i][j]+=scores[i-1][j];
                }
                if(j%3==0){
                    scores[i][j]+=1;
                }
                if(j%7==0){
                    scores[i][j]+=1;
                }
            }
        }
        print(scores);
        return scores[scores.length-1][scores[0].length-1];
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
