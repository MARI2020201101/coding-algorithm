package perfectcoding.array;

import java.util.Arrays;

class Partition {
 public static void main(String[] args) {
  int[] arr = {4,2,5,1,6,7,3};
  System.out.println(partition(arr, 0, arr.length-1));
  System.out.println(Arrays.toString(arr));
 }
    static int partition(int[] arr, int left , int right){
      int point = left;
      int pivot = arr[right];
     for (int i = point; i < right; i++) {
      if(arr[i] <= pivot){
        swap(arr, point++, i);
      }
     }
     swap(arr, point, right);
     return point;
    }
    static void swap(int[] arr, int p1, int p2){
     int tmp = arr[p1];
     arr[p1] = arr[p2];
     arr[p2] = tmp;
    }
 }
