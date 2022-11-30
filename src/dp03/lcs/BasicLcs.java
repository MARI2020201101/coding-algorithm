package dp03.lcs;

import java.util.Arrays;

class BasicLcs {
    public static void main(String[] args) {
        int[] arr ={6,2,5,1,7,4,8,3};
        int[] lcs = new int[arr.length];
        init(arr, lcs);
        System.out.println(Arrays.toString(lcs));
    }
    static void init(int[] arr, int[] lcs){
        lcs[0] =1;
        for (int i = 1; i < lcs.length; i++) {
            lcs[i] = arr[i-1] < arr[i]? lcs[i-1]+1 : lcs[i-1];
        }
    }
}
