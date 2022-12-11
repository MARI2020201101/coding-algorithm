package ds.greedy.minwait;

import java.util.Arrays;

class MinWait {
    static int[] arr = {2,5,1,3};

    public static void main(String[] args) {
        System.out.println(minWait(arr));
    }
    static int minWait(int[] arr){
        Arrays.sort(arr);
        int size = arr.length - 1;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result+=arr[i] * (size-i);
        }
        return result;
    }
}
