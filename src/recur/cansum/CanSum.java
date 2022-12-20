package recur.cansum;

class CanSum {
    public static void main(String[] args) {
        int[] arr = {1,5,7,10,15};
        System.out.println(solve(arr, 12, 0));
        System.out.println(solve(arr, 14, 0));
    }
    static boolean solve(int[] arr, int n, int i){
        if(i >= arr.length) return false;
        else if(n == 0) return true;
        else if(n < 0) return false;

        return solve(arr, n-arr[i], i+1) || solve(arr, n, i+1);
    }
}
