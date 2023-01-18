package dynamic;

class MaxKthProfit {
    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        int k = 3;

        System.out.println("The maximum possible profit is " + maxKthProfit(price, k));
    }
    static int maxKthProfit(int[] prices, int k){
        int n = prices.length;
        int[][] profit = new int[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < j; l++) {
                    if(i-1 < 0){
                        profit[i][j] = prices[j] - prices[l];
                        continue;
                    }
                    int currProfit = prices[j] - prices[l] + profit[i - 1][l];
                    profit[i][j] = Math.max(profit[i][j], currProfit);
                }
            }
        }
        print(profit);
        return profit[k-1][n-1];
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
