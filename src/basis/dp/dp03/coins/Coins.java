package basis.dp.dp03.coins;

class Coins {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int money = 6;
        int[] coins = {1,3,4};
        recur(money, coins, 0);
        System.out.println(min);
    }
    static void recur(int money, int[] coins, int n){
        if(money == 0){
            min = Math.min(min, n);
            return;
        }
        else if(money < 0){
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            recur(money - coins[i], coins, n+1);
        }
    }
}
