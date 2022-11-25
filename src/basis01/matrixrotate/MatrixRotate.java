package basis01.matrixrotate;

class MatrixRotate {
    static int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16},
    };

    public static void main(String[] args) {
        rotate(arr);
    }
    static void rotate(int[][] arr){
        int offset = 0;
        int i = 0;
        int j = 0;
        int len = arr.length;
        for (offset = 0; offset < len/2; offset++) {
            for (int k = 0; k < len-offset; k++) {
                int lTop = arr[i+offset][j+k+offset];
                int rTop = arr[i+k+offset][j+len-offset-1];
                int rBottom = arr[j+len-offset-1][j+len-offset-1-k];
                int lBottom = arr[j+len-offset-1-k][j+offset];
                System.out.println(String.format("lTop=%d,rTop=%d,rBottom=%d,lBottom=%d",lTop,rTop,rBottom,lBottom));
            }
        }

    }
}
