package xsolution;

class IsSquare {
    static SubSquare findSquare(int[][] matrix){
        for (int i = matrix.length; i >=0 ; i--) {
            SubSquare subSquare = findSquareWithSize(matrix, i);
            if(subSquare!=null) return subSquare;
        }
        return null;
    }

    private static SubSquare findSquareWithSize(int[][] matrix, int squareSize) {
        int count = matrix.length - squareSize +1 ;
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if(isSquare(matrix, row, col, squareSize )){
                    return new SubSquare(row,col,squareSize);
                }
            }
        }
        return null;
    }

    private static boolean isSquare(int[][] matrix, int row, int col, int squareSize) {
        for (int i = 0; i < squareSize; i++) {
            if(matrix[row][col+i] == 1){
                return false;
            }
            if(matrix[row+squareSize-1][col+i] == 1){
                return false;
            }
        }
        for (int i = 0; i < squareSize; i++) {
            if(matrix[row+i][col] == 1){
                return false;
            }
            if(matrix[row+i][col+squareSize-1] == 1){
                return false;
            }
        }
        return true;
    }

}
class SubSquare{
    int row;
    int col;
    int size;

    public SubSquare(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }
}