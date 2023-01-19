package thisiscodingtest.sort;

import java.util.Arrays;

class FailureRate {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2,1,2,6,2,4,3,3};
        int[] rank = rate(n, arr);
        System.out.println(Arrays.toString(rank));
    }
    static int[] rate(int n, int[] arr){
        double[] count = new double[n+1];
        double people = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i] > j){
                    count[j] += 1/people;
                }
            }
        }
        System.out.println(Arrays.toString(count));
        int[] rank = new int[n];
        for (int i = 1; i < count.length; i++) {
            for (int j = i+1; j < count.length; j++) {
                if(count[i] >= count[j]){
                    rank[i-1]++;
                }
            }
        }
        return rank;
    }
}
