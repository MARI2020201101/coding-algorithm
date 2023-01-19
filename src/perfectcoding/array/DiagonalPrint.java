package perfectcoding.array;

class DiagonalPrint {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20},
        };
        print(arr);
    }
    static void print(int[][] arr){
        int n = arr.length-1;
        int m = arr[0].length-1;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

    }

}
