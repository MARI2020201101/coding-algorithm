package thisiscodingtest.implementation;

class CountTimeThree {
    public static void main(String[] args) {
        System.out.println(countTimeThree(5));
    }
    static int countTimeThree(int N){
        int[] threes = {3,13,23,30,31,32,33,34,35,36,37,38,39,43,53};
        int count = 0;
        for (int h = 0; h < N + 1; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    String strTime = String.valueOf(h +":"+ m +":"+ s);
                    System.out.println(strTime);
                    if(strTime.contains("3")) count++;
                }
            }

        }
        return count;
    }
}
