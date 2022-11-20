package basis01.matrixspiral;

import java.util.ArrayList;
import java.util.List;

class MatrixSpiralOrder {
    static List<Integer> matrixSpiralOrder(int[][] arr){
        List<Integer> spiral = new ArrayList<>();
        int offset = arr.length-2;
        for (int i = 0; i <= offset && offset>0; i++) {
            for (int j = 0; j <= offset; j++) {
                spiral.add(arr[i][j]);
            }
            offset-=2;
        }
        return spiral;
    }
}
