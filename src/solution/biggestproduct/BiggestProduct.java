package solution.biggestproduct;

import java.util.Arrays;

class BiggestProduct {
    public static void main(String[] args) {
        int[] arr = {3,2,-1,4,-1,6};
        System.out.println(findBiggestProduct(arr ));
    }
    static int findBiggestProduct(int[] arr){
        int[] suffix = new int[arr.length];
        int[] prefix = new int[arr.length];
        int product = 1;
        for (int i = arr.length-1; i >=0 ; i--) {
            product *= arr[i];
            suffix[i]=product;
        }
        product = 1;
        for (int i = 0 ; i < arr.length ; i++) {
            product *= arr[i];
            prefix[i]=product;
        }
        int biggest = Integer.MIN_VALUE;
        for (int i = 0; i < suffix.length; i++) {
            int pre = i==0? 1 : prefix[i-1];
            biggest = Math.max(biggest, pre * suffix[i]);
        }

        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(prefix));
        return biggest;
    }
}
