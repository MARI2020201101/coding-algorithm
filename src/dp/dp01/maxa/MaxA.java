package dp.dp01.maxa;

import java.util.Arrays;

class MaxA {
    public static void main(String[] args) {
        System.out.println(maxA(7));
    }
    static int maxA(int n){
        int[] result = new int[n+1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int i = 0; i+3 < result.length; i++) {
            result[i+3] = Math.max(result[i+3], result[i]*2);
        }
        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).max().getAsInt();
    }
}
