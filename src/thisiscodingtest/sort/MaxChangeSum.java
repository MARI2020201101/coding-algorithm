package thisiscodingtest.sort;

import java.util.Arrays;

class MaxChangeSum {
    static int solve(int[] a, int[] b , int k){
        int max = Arrays.stream(b).max().getAsInt();
        for (int i = 0; i < k; i++) {
            int minIdx = 0;
            for (int j = 0; j < a.length; j++) {
                minIdx = a[minIdx] < a[j] ? minIdx : j;
            }
            a[minIdx] = max;
        }
        return Arrays.stream(a).sum();
    }
}
