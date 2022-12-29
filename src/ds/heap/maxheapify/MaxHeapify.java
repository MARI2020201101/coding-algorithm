package ds.heap.maxheapify;

import java.util.Arrays;

class MaxHeapify {
    public static void main(String[] args) {
        int[] arr = {4,1,3,2,16,9,10,14,8,7};
        maxHeapify(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void maxHeapify(int[] arr){
        int len = arr.length;
        for (int i = len / 2 ; i >= 0; i--) {
            __maxHeapify(arr, i);
        }
    }
    static void __maxHeapify(int[] arr, int parent){
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int largest = arr[parent];
        if(leftChild >= arr.length){
            return;
        }
        else if(rightChild >= arr.length){
            largest = Math.max(arr[parent], arr[leftChild]);
            if(arr[parent] != largest){
                swap(arr, parent, leftChild);
            }
        }
        else{
            largest = Math.max(arr[parent], Math.max(arr[leftChild], arr[rightChild]));
            if(arr[parent] != largest){
                int maxIdx = Math.max(arr[leftChild], arr[rightChild]) == arr[leftChild] ? leftChild : rightChild;
                swap(arr, parent, maxIdx);
            }
        }

    }
    static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
