package basis01.matrixrotate;

import java.util.ArrayList;
import java.util.List;

class MatrixRotate3 {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1,2,3,4));
        matrix.add(List.of(5,6,7,8));
        matrix.add(List.of(9,10,11,12));
        matrix.add(List.of(13,14,15,16));

        rotate(matrix);
    }

    static void rotate(List<List<Integer>> matrix){
        int matrixSize = matrix.size() - 1;
        for (int i = 0; i < matrix.size() / 2; ++i) {
            for (int j = i; j < matrixSize - i; ++j) {
                Integer tmp1 = matrix.get(matrixSize - j).get(i);
                Integer tmp2 = matrix.get(matrixSize - i).get(matrixSize - j);
                Integer tmp3 = matrix.get(j).get(matrixSize - i);
                Integer tmp4 = matrix.get(i).get(j);

                System.out.println(String.format("matrixSize-j= %d , i = %d ",matrixSize - j,i ));
                System.out.println(String.format("matrixSize-i= %d , matrixSize - j = %d ",matrixSize - i,matrixSize - j ));
                System.out.println(String.format("j= %d , matrixSize - i = %d ",j,matrixSize - i));
                System.out.println(String.format("i= %d , j = %d ",i,j ));
            }
        }
    }
}
