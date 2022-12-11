package dp.dp03.countsolutioncoins;

class Coins {
    public static void main(String[] args) {
        int[] coins = {1,3,4};
        int count = count(5, 0, coins);
        System.out.println(count);
    }
    static int count(int money, int count, int[] coins){
        if(money == 0){
            count+=1;
            return count;
        }else if(money < 0){
            return count;
        }
        int result = 0;
        for (int i = 0; i <coins.length; i++){
            result += count(money-coins[i], count, coins);
        }
        return result;
    }
}
