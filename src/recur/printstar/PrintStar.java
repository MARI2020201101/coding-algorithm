package recur.printstar;

class PrintStar {
    public static void main(String[] args) {
//        printStar(new StringBuilder(), 27);
        printStar(27);
    }
    static void printStar(StringBuilder sb, int len){
        if(len <= 0){
            System.out.println(sb.toString());
            return;
        }
        int start = 0;
        int end = len;
        int div1 = (start+start+end)/3;
        int div2 = (start+end+end)/3;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                if(i>=div1 && i<=div2 && j >=div1 && j <=div2){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        printStar(sb, len/3);
    }
    static void printStar(int n){
        char[][] arr = new char[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = '*';
            }
        }
        __printStar(arr, 0, n);
    }
    static void __printStar(char[][] arr, int start, int end){
        if(end - start <= 1){
            __print(arr);
            return;
        }
        int left = start;
        int right = end;
        int div1 = (left+left+right)/3;
        int div2 = (left+right+right)/3;

        for (int i = div1; i <= div2; i++) {
            for (int j = div1; j <=div2 ; j++) {
                arr[i][j] = ' ';
            }
        }
        __printStar(arr, left, div1);
        __printStar(arr, div1, div2);
        __printStar(arr, div2, right);

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
