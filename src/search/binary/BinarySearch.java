package search.binary;

class BinarySearch {
    static int[] arr = {1,3,3,4,5,5,6,9,10,12,12,15};

    public static void main(String[] args) {
        int target = 9;
        int index = binarySearch(arr, target);
        System.out.println("index = " + index);
    }
    static int binarySearch(int[] arr , int target){
        int len = arr.length;
        int curr = 0;
        for (int offset = len/2; offset < len && offset > 0; offset/=2) {
            System.out.println(String.format("offset=%d, curr=%d", offset, curr));
            while(curr + offset < len && arr[curr+offset] <= target) {
                curr+=offset;
            }
        }
        if(arr[curr] == target) return curr;
        return -1;
    }
}
