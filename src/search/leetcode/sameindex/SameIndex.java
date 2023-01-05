package search.leetcode.sameindex;

class SameIndex {
    static int[] arr = {-2,0,2,3,6,7,9};

    public static void main(String[] args) {
        System.out.println(search(arr));
    }
    static int search(int[] arr){
        return search(arr, 0, arr.length-1);
    }

    private static int search(int[] arr, int start, int end) {
        while(start<=end){
            int mid = (start+end)/2;
            if(mid < arr[mid]){
                end = mid-1;
            }else if(mid > arr[mid]){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return start;
    }
}
