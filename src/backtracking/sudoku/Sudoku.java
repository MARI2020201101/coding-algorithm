package backtracking.sudoku;

class Sudoku {
    static int[][] sudoku = {
            {0, 3, 5, 4, 6, 9, 2, 7, 8},
            {7, 8, 2, 1, 0, 5, 6, 0, 9},
            {0, 6, 0, 2, 7, 8, 1, 3, 5},
            {3, 2, 1, 0, 4, 6, 8, 9, 7},
            {8, 0, 4, 9, 1, 3, 5, 0, 6},
            {5, 9, 6, 8, 2, 0, 4, 1, 3},
            {9, 1, 7, 6, 5, 2, 0, 8, 0},
            {6, 0, 3, 7, 0, 1, 9, 5, 2},
            {2, 5, 8, 3, 9, 4, 7, 6, 0},
    };

    public static void main(String[] args) {
        sudoku(sudoku,0,0);
    }
    static void sudoku(int[][] sudoku, int i , int j){
        if(j == 9){
            sudoku(sudoku, i+1, 0);
        }
        if(i == 9){
            print(sudoku);
            return;
        }
        if(sudoku[i][j]!=0){
            sudoku(sudoku, i, j+1);
        }
        for (int k = 1; k <= 9; k++) {

            if(! isValid(sudoku, i, j ,k)) continue;
            sudoku[i][j] = k;
            sudoku(sudoku, i, j+1);

            sudoku[i][j] = 0;
    }
    }

    private static boolean isValid(int[][] sudoku, int r, int c, int k) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[r][i]==k) return false;
            if(sudoku[i][c]==k) return false;
            if(sudoku[(r/3)*3+(i/3)][(c/3)*3+(i%3)]==k) return false;
        }

        return true;
    }

    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
