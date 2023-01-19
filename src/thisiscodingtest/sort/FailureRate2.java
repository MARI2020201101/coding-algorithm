package thisiscodingtest.sort;

import java.util.Arrays;

class FailureRate2 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2,1,2,6,2,4,3,3};
        rate(n, arr);
    }
    static int[] rate(int n, int[] arr){
        double[] count = new double[n];
        double people = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i] > j+1){
                    count[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(count));
        return null;
    }
}
