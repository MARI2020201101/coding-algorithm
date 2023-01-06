package search;

import java.util.ArrayList;
import java.util.List;

class MatrixInSpiralOrder {
    static List<Integer> matrixInSpiralOrder(List<List<Integer>> matrix){
        List<Integer> spiralOrdering = new ArrayList<>();
        for (int offset = 0; offset < matrix.size() / 2; offset++) {
            matrixInSpiralOrder(matrix, offset, spiralOrdering);
        }
        return spiralOrdering;
    }

    private static void matrixInSpiralOrder(List<List<Integer>> matrix, int offset, List<Integer> spiralOrdering) {
        if(offset == matrix.size() - offset - 1){
            spiralOrdering.add(matrix.get(offset).get(offset));
        }
        for (int i = offset; i < matrix.size()-offset-1; i++) {
            spiralOrdering.add(matrix.get(offset).get(i));
        }
        for (int i = offset; i < matrix.size()-offset-1; i++) {
            spiralOrdering.add(matrix.get(i).get(matrix.size()-offset-1));
        }
        for (int i = matrix.size()-offset-1; i > offset ; i--) {
            spiralOrdering.add(matrix.get(matrix.size()-offset-1).get(i));
        }
        for (int i = matrix.size()-offset-1; i > offset ; i--) {
            spiralOrdering.add(matrix.get(i).get(offset));
        }
    }
}
