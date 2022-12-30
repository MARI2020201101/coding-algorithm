package xsolution;

class SelectEqualsOrSmaller {
    static int selectEqualsOrSmaller(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        int pivot = arr[(start+end)/2];
        PartitionResult partitionResult = selectEqualsOrSmaller(arr, start, end,pivot);
        int equalsSize = partitionResult.equalsSize;
        int smallerSize = partitionResult.smallerSize;
        if(k < smallerSize){
            selectEqualsOrSmaller(arr, start, smallerSize-1, arr[(start+(smallerSize-1))/2]);
        }else if(k < smallerSize + equalsSize){
            return pivot;
        }else{
            selectEqualsOrSmaller(arr, equalsSize, end, arr[(equalsSize+end)/2]);
        }
        return -1;
    }

    private static PartitionResult selectEqualsOrSmaller(int[] arr, int start, int end,  int pivot) {

        int middle = start;
        int left = start;
        int right = end;

        while(middle <= right){
            if(arr[middle] > pivot){
                swap(arr, left, middle);
                left++;
                middle++;
            }else if(arr[middle] < pivot){
                swap(arr, middle, right);
                right--;
            }else {
                middle++;
            }
        }

        return new PartitionResult(left-start, middle - left + 1);
    }
    static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
class PartitionResult{
    int smallerSize;
    int equalsSize;

    public PartitionResult(int smallerSize, int equalsSize) {
        this.smallerSize = smallerSize;
        this.equalsSize = equalsSize;
    }
}