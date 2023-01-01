package xsolution.search;

import java.util.Arrays;

class FindMissingTwo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,8,9,10};
        System.out.println(Arrays.toString(findMissingTwo(arr)));
    }
    static int[] findMissingTwo(int[] arr){
        int x2y2 = calX2Y2(arr);
        int xplusy = calxPlusY(arr);

        for (int i = 0; i < arr.length; i++) {
            x2y2-=Math.pow(arr[i],2);
            xplusy-=arr[i];
        }

        return findMissingTwo(xplusy, x2y2);
    }

    private static int[] findMissingTwo(int xplusy, int x2y2) {
        int a = 2;
        int b = -2*(xplusy);
        int c = xplusy * xplusy - x2y2;
        System.out.println("a = "+a + " , b="+ b+" , c= "+c);

        double part1 = -1*b;
        double part2 = Math.sqrt(b*b - 4*a*c);
        double part3 = 2*a;

        int x = (int) ((part1+part2)/part3);
        int y = xplusy - x;
        return new int[]{x,y};
    }

    private static int calxPlusY(int[] arr) {
        int n = arr.length + 2;
        return (n*(n+1))/2;
    }

    private static int calX2Y2(int[] arr) {
        int result = 0;
        for (int i = 1; i <= arr.length+2; i++) {
            result += Math.pow(i, 2);
        }
        return result;
    }
}
