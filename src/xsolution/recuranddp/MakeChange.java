package xsolution.recuranddp;

class MakeChange {
    public static void main(String[] args) {
        int[] coins = {25,10,5,1};
        System.out.println(makeChange(100, coins, 0));
    }
    static int makeChange(int amount, int[] coins, int index){
        if(amount == 0) return 1;
        else if(amount < 0) return 0;
        else if(index >= coins.length) return 0;
        int coin = coins[index];
        int count = 0;
        for (int i = 0; i * coin <= amount ; i++) {
            count+=makeChange(amount - (i*coin), coins, index+1);
        }
        return count;
    }
}
