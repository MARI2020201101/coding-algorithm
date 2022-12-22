package recur.printnum;

class PrintNum {


    public static void main(String[] args) {
        printNum(2);
//        printNum(3);
    }
    static void printNum(int n){
        double pow = Math.pow(2, n);
        int[][] arr = new int[(int)pow][(int)pow];
        __printNum(arr, 0, 0 ,1, (int)pow);
        __print(arr);
    }

    private static void __printNum(int[][] arr, int start, int end, int num ,int N) {
        if(N == 2){
            for (int i = start; i < start+2 ; i++) {
                for (int j = end; j < end+2 ; j++) {
                    arr[i][j] = num++;
                }
            }

            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                __printNum(arr, start + i*(N/2), end + j*(N/2), num, N/2);
                num+=4;
            }
        }

    }
    static void __print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
