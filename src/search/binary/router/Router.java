package search.binary.router;

import java.util.Arrays;

class Router {
    public static void main(String[] args) {
        int[] arr = {1,2,8,4,9};
        int[][] distance = distance(arr);

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }
    static int[][] distance(int[] arr){
        int[][] distance = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                distance[i][j] = Math.abs(arr[i]-arr[j]);
            }
        }
        return distance;
    }
    static int solve(int[] arr, int k){
        int start = 1;
        int end = Arrays.stream(arr).max().getAsInt();
        int count = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(canAllocate(distance(arr), mid, k)){
                start =  mid+1;
            }else{
                end = mid-1;
            }
        }
        return count;
    }

    private static boolean canAllocate(int[][] distance, int mid, int k) {
        return false;
    }
}
