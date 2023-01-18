package dynamic;

class MaxKthProfit3 {
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
                    int prevProfit = i-1 < 0 ? 0 : profit[i - 1][l];
                    int currProfit = prices[j] - prices[l] + prevProfit;
                    int prevMax = j-1 < 0 ? 0 : profit[i][j-1];
                    profit[i][j] = Math.max(prevMax, currProfit);
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
