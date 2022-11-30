package dp03.knapsack;

import java.util.Arrays;

class Possible {
    public static void main(String[] args) {
        int x = 12;
        int[] weight = {1,3,3,5};
        int[] possible = new int[x+1];
        possible(weight, possible);
        System.out.println(Arrays.toString(possible));
    }

    static int[] possible(int[] weight, int[] possible){
        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if(i + weight[j] < possible.length){
                    possible[i+weight[j]] += 1;
                }
            }
        }
        return possible;
    }
}
