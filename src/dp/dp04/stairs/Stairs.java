package dp.dp04.stairs;

class Stairs {
    public static void main(String[] args) {
        System.out.println(countWays(4,2));
    }
    static int countWays(int stairs, int jump){
        if(stairs == 0){
            return 1;
        }else if(stairs < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= jump; i++) {
            count+=countWays(stairs-i, jump);
        }
        return count;
    }
}
