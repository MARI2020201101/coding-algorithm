package xsolution;

import java.util.Arrays;

class MassageTime {
    public static void main(String[] args) {
        int[] arr = {30,15,60,75,45,15,15,45};
        System.out.println(maxMassageTime(arr));
    }
    static int maxMassageTime(int[] arr){
        int[] sum = new int[arr.length+2];
        for (int i = arr.length-1; i >=0 ; i--) {
             sum[i]= Math.max(arr[i] + sum[i+2], sum[i+1]);
        }
        return sum[0];
    }
}
