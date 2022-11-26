package dp.balloon;

class Balloon {
    public static void main(String[] args) {
        int[][] arr = balloon(N, value);
        print(arr);
    }
    static int N = 10;
    static int[] value = {9,2,8,7,3,2,4,5,10,1};
    static int[][] balloon(int n , int[] value){
        int[][] arr = new int[n+1][n+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = n-1; k >=0 ; k--) {
                    arr[i][j] = Math.max(
                            arr[i][j],
                            arr[i][k] + arr[k][j] + value[i]*value[k]*value[j]
                    );
                }
            }
        }
        return arr;
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
