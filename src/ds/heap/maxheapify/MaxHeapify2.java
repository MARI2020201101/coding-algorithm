package ds.heap.maxheapify;

import java.util.Arrays;

class MaxHeapify2 {
    public static void main(String[] args) {
        int[] arr = {4,1,3,2,16,9,10,14,8,7};
        maxHeapify(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void maxHeapify(int[] arr){
        for (int i = arr.length/2; i >=0 ; i--) {
            __maxHeapify(arr, i);
        }
    }
    static void __maxHeapify(int[] arr, int parent){
        int leftChildIdx = parent * 2 + 1;
        int rightChildIdx = parent * 2 + 2;
        int lastIdx = arr.length - 1;
        int largest = arr[parent];

        if(leftChildIdx <= lastIdx && arr[leftChildIdx] > largest){
            largest = arr[leftChildIdx];
        }

        if(rightChildIdx <= lastIdx && arr[rightChildIdx] > largest){
            largest = arr[rightChildIdx];
        }

        if(largest != arr[parent]){
            if(largest == arr[leftChildIdx]){
                swap(arr, parent, leftChildIdx);
                __maxHeapify(arr, leftChildIdx);
            }else{
                swap(arr, parent, rightChildIdx);
                __maxHeapify(arr, rightChildIdx);
            }
        }

    }
    static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
