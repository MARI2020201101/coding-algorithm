package basis.basis01.matrixrotate;

public class MatrixRotate2 {
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
        int rotateMax = (arr.length-1)/2 ;
        int len = arr.length;
        for (int i = 0; i < rotateMax; i++) {
            for (int j = 0; j < len - i; j++) {
                int lTop = arr[i][j];
                int rTop = arr[j][len - j - 1];
                int rBottom = arr[len - j - 1][len - j - 1];
                int lBottom = arr[len - j - 1][i];
                System.out.println(String.format("i=%d,j=%d",i,j));
                System.out.println(String.format("j=%d,len-j-1=%d",j,len-j-1));
                System.out.println(String.format("len-j-1=%d,len-j-1=%d",len-j-1,len-j-1));
                System.out.println(String.format("len-j-1=%d,i=%d",len-j-1,i));
            }
            System.out.println("====");
        }

    }
}
