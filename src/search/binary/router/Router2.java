package search.binary.router;

import java.util.Arrays;

class Router2 {
    public static void main(String[] args) {
        int[] arr = {1,2,8,4,9};
        System.out.println(solve(arr, 3));
    }

    static int solve(int[] arr, int k){
        int start = 1;
        int end = Arrays.stream(arr).max().getAsInt();
        Arrays.sort(arr);
        while(start <= end){
            System.out.println("start = "+start +", end="+end);
            int mid = (start+end)/2;
            if(canAllocate(arr, mid, k)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }

    private static boolean canAllocate(int[] arr, int mid, int k) {
        int allocated = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[allocated] - arr[i]) >= mid) {
                count++;
                allocated = i;
            }
        }
        return count>=k;
    }


}
