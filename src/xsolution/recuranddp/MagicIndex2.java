package xsolution.recuranddp;

class MagicIndex2 {

    public static void main(String[] args) {
        int[] arr = {-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println(solve(arr));
    }
    static int solve(int[] arr){
        return solve(arr, 0, arr.length-1);
    }

    private static int solve(int[] arr, int start, int end) {
       if(start>end){
           return -1;
       }

       int mid = (start+end)/2;

       if(arr[mid] == mid) {
           return mid;
       }
       int nextStart = Math.min(arr[mid], mid-1);
       int nextEnd = Math.max(arr[mid], mid+1);
       int left = solve(arr, start, nextStart);
       int right = solve(arr, nextEnd, end);
       int solve = left==-1 ? right : left;
       return solve;
    }

}
