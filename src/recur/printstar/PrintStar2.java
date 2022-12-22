package recur.printstar;

class PrintStar2 {
    public static void main(String[] args) {
        printStat(27);
    }
    static void printStat(int n){
        char[][] arr = new char[n+1][n+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = ' ';
            }
        }
        __printStar(arr, 0, 0,n);
        __print(arr);
    }
    static void __printStar(char[][] arr, int start, int end, int n){
        if(n == 1){
            arr[start][end] = '*';

            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)){
                    __printStar(arr, start+i*(n/3),end+j*(n/3),n/3 );
                }
            }
        }
    }
    static void __print(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
