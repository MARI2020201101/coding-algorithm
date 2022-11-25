package dp.maxa;

import java.util.Arrays;

public class MaxA3 {
    public static void main(String[] args) {
        System.out.println(maxA(7));
        System.out.println(maxA(9));
    }
    static int maxA(int n){
        int[] result = new int[n+1];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1]+1;
            for (int j = 1; j < i ; j++) {
                result[i] = Math.max(result[i], result[j]*(i-j-1));
            }
        }
        System.out.println(Arrays.toString(result));
        return result[n];
    }
}
