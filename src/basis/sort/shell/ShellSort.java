package basis.sort.shell;

import java.util.Arrays;

class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4,8,9,1,10,6,2,5,3,7};
        System.out.println(Arrays.toString(sort(arr)));
    }
    static int[] sort(int[] arr){
        int[] g = {4,3,1};
        for (int i = 0; i < g.length; i++) {
            arr = __sort(arr, arr.length, g[i]);
        }
        return arr;
    }
    static int[] __sort(int[] arr, int n, int g){
        for (int i = g; i < n; i++) {
            int value = arr[i];
            int j = i-g;
            while(j >= 0 && arr[j] > value){
                System.out.println(String.format("j=%d,g=%d, arr[j+g]=%d, arr[j]=%d", j,g,arr[j+g],arr[j] ));
                arr[j+g] = arr[j];
                j = j-g;
            }
            arr[j+g] = value;
        }
        return arr;
    }
}
