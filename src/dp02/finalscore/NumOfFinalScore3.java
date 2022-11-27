package dp02.finalscore;

import java.util.Arrays;

class NumOfFinalScore3 {
    public static void main(String[] args) {
        System.out.println(numOfFinalScore(12));
    }
    static int numOfFinalScore(int n){
        int[] scores = new int[n+1];
        scores[0]=1;
//        scores[2]=1;
//        scores[3]=1;
//        scores[7]=1;
        for (int i = 0; i < scores.length; i++) {
            if(i-2>=0){
                scores[i] = scores[i-2]+1;
            }
            if(i-3>=0){
                scores[i] = scores[i-3] +1;
            }
            if(i-7>=0){
                scores[i] = scores[i-7]+1;
            }
        }
        System.out.println(Arrays.toString(scores));
        return scores[n];
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
