package search.binary.allocation;

import java.util.Arrays;

class Allocation {
    public static void main(String[] args) {
        int[] arr = {8,1,7,3,9};
        int limit = 3;
        System.out.println(solve(arr, limit));
    }
    static int solve(int[] arr, int limit){
        int left = 1;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            right+=arr[i];
        }

        while(left <= right){
            int mid = left + ((right-left)/2);
            int sum = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                sum+=arr[i];
                if(sum > mid){
                    count++;
                    sum = arr[i];
                }else if(sum == mid){
                    count++;
                    sum = 0;
                }
            }
            if(sum > 0){
                count++;
            }

            if(count > limit){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
