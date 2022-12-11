package basis.basis01.plusone;

import java.util.Arrays;

class Plusone {
    public static void main(String[] args) {
        int[] a = {1,9,3,7,0,7,7,2,1};
        int[] b = {7,6,1,8,2,5,7,2,8};
        System.out.println(Arrays.toString(multiply(a,b)));
    }
    static int[] multiply(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        for (int i = a.length-1; i >=0 ; i--) {
            for (int j = b.length-1; j >= 0; j--) {
                    result[i+j+1] =  result[i+j+1] + a[i]*b[j];
                    result[i+j] =  result[i+j] + result[i+j+1]/10;
                    result[i+j+1] %= 10;
            }
        }
        return result;
    }
}
