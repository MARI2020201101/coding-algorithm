package xsolution.recuranddp;

class MagicIndex {

    public static void main(String[] args) {
        int[] arr = {-40,-20,-1,1,2,3,5,7,9,12,13};
        System.out.println(solve(arr));
    }
    static int solve(int[] arr){
        return solve(arr, 0, arr.length);
    }

    private static int solve(int[] arr, int start, int end) {
        while(start < end){
            int mid = (start+end)/2;

            if(arr[mid] == mid){
                return mid;
            }else if(arr[mid] > mid){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

}
