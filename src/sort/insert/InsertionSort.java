package sort.insert;

import java.util.Arrays;

class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }
    static int[] sort(int[] arr){
        for (int i = arr.length-1; i >= 0 ; i--) {
            int val = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > val){
                arr[i] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
        return arr;
    }
}
