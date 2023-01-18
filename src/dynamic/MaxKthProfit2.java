package dynamic;

class MaxKthProfit2 {
    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        int k = 3;

        System.out.println("The maximum possible profit is " + maxKthProfit(price, k));
    }
    static int maxKthProfit(int[] prices, int k){
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[][] profit = new int[k + 1][n];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                }
                else {
                    int max_so_far = 0;
                    for (int x = 0; x < j; x++) {
                        int curr_price = prices[j] - prices[x] + profit[i-1][x];
                        if (max_so_far < curr_price) {
                            max_so_far = curr_price;
                        }
                    }
                    profit[i][j] = Math.max(profit[i][j-1], max_so_far);
                }
            }
        }
        print(profit);
        return profit[k][n-1];
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
