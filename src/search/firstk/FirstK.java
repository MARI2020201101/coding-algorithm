package search.firstk;

class FirstK {
    static int[] arr = {-14,-10,2,108,108,243,285,285,285,401};

    public static void main(String[] args) {
        System.out.println(search(arr, 108));
        System.out.println(search(arr, 285));
    }
    static int search(int[] arr, int k){
        return search(arr, 0, arr.length-1,k);
    }

    private static int search(int[] arr, int start, int end, int k) {
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] < k){
                start = mid+1;
            }else if(arr[mid] == k){
                end = mid-1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}
