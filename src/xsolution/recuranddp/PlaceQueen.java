package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PlaceQueen {
    public static void main(String[] args) {
        Integer[] cols = new Integer[SIZE];
        List<Integer> results = new ArrayList<>();
        placeQueens(0,cols, results);
        results.forEach(System.out::println);
    }
    static Integer SIZE = 8;
    static void placeQueens(int row, Integer[] colums, List<Integer> results){
        if(row == SIZE) {
            results.addAll(List.of(colums.clone()));
            return;
        }
        for (int col = 0; col < SIZE; col++) {
            if(canPlace(row, colums, col)){
                colums[row] = col;
                placeQueens(row+1, colums, results);
                colums[row] = 0;
            }
        }
    }

    private static boolean canPlace(int row1, Integer[] colums, int col) {
        for (int row2 = 0; row2 < row1; row2++) {
            Integer prev = colums[row1];
            if(prev == null) return true;
            if(prev == col) return false;
            int rowDiff = row1 - row2;
            int colDiff = Math.abs(prev - col);
            if(rowDiff == colDiff) return false;
        }
        return true;
    }
}
