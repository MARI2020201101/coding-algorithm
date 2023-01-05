package thisiscodingtest.binary;

import java.util.Arrays;

class RiceCake {

    public static void main(String[] args) {
        int[] riceCakes = {19,15,10,17};
        int targetLength = 6;
        System.out.println(solve(riceCakes,targetLength));
    }
    static int solve(int[] riceCakes, int targetLength){
        Arrays.sort(riceCakes);
        return binarySearch(riceCakes, targetLength);
    }

    static int checkLength(int[] riceCakes, int cutLen){
        int total = 0;
        for (int i = 0; i < riceCakes.length; i++) {
            total+=Math.max(riceCakes[i]-cutLen, 0);
        }
        return total;
    }
    static int binarySearch(int[] riceCakes, int targetLength){
        int min = 0;
        int max = riceCakes[riceCakes.length-1];
        while(min < max){
            int medium = (min+max)/2;
            System.out.println("medium = " + medium);
            if(checkLength(riceCakes, medium) == targetLength){
                return medium;
            }else if(checkLength(riceCakes, medium) < targetLength){
                max = medium-1;
            }else {
                min = medium+1;
            }
        }
        return min-1;
    }
}
