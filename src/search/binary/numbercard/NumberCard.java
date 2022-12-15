package search.binary.numbercard;

import java.util.Arrays;

class NumberCard {
    public static void main(String[] args) {
        int[] arr = {6,3,2,10,10,10,-10,-10,7,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] target = {10,9,-5,2,3,4,5,-10};
        for (int i = 0; i < target.length; i++) {
            System.out.print(lowerBound(arr, target[i]) + ",");
            System.out.println(upperBound(arr, target[i]));
        }
    }
    static int lowerBound(int[] arr, int k){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+((right-left)/2);
            if(arr[mid] < k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    static int upperBound(int[] arr, int k){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+((right-left)/2);
            if(arr[mid] <= k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
}
