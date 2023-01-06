package search;

import java.util.ArrayList;
import java.util.List;

class MatrixInSpiralOrder2 {
    static List<Integer> matrixInSpiralOrder(List<List<Integer>> matrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        final int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < matrix.size() * matrix.size(); i++) {
            spiralOrdering.add(matrix.get(x).get(y));
            matrix.get(x).set(y, 0);
            int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
            if (nextX < 0 || nextX >= matrix.size() || nextY < 0 || nextY >= matrix.size() ||
                    matrix.get(nextX).get(nextY) == 0) {
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }
        return spiralOrdering;
    }
}
