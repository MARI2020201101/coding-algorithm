package basis.sort.bubble;

import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};
        int[] arr = {5,3,2,4,1};
        System.out.println(Arrays.toString(sort(arr)));


    }
    static int[] sort(int[] arr){
        boolean changed = true;
        int count = 0;
        while(changed){
            for (int j = 0; j < arr.length; j++) {
                for (int i = arr.length-1; i >0 ; i--) {
                    changed = false;
                    if(arr[i] < arr[i-1]){
                        int tmp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = tmp;
                        changed = true;
                        count++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
        return arr;
    }
}
