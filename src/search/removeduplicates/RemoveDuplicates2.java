package search.removeduplicates;

import java.util.Arrays;

class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicates(arr)));
    }
    static int[] removeDuplicates(int[] arr){
        int slow = 0;
        int fast = 1;
        while(slow <arr.length && fast<arr.length){
            if(arr[slow] != arr[fast]){
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;

        }
        return arr;
    }
}
