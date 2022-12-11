package dp.dp03.knapsack;

import java.util.Arrays;

class Possible2 {
    public static void main(String[] args) {
        int x = 12;
        int[] weight = {3,3,5};
        boolean[] possible = new boolean[x+1];
        possible(weight, possible);
        System.out.println(Arrays.toString(possible));
    }

    static void possible(int[] weight, boolean[] possible){
        possible[possible.length-1] = true;
        for (int i = possible.length-1; i >=0 ; i--) {
            for (int j = 0; j < weight.length; j++) {
                if(i-weight[j]>=0){
                    possible[i-weight[j]] |= possible[i];
                }
            }
        }
    }
}
