package xsolution;

class FindSquare {
    SubSquare findSquare(int[][] matrix){
        SquareCell[][] processed = processSquare(matrix);
        for (int i = matrix.length; i >=1; i--){
            SubSquare square = findSubSquareWithSize(processed, i);
            if(square!=null) return square;
        }
        return null;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length-1; r >=0 ; r--) {
            for (int c = matrix.length-1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;
                if(matrix[r][c] == 0){
                    rightZeros++;
                    belowZeros++;
                    if(c+1 < matrix.length){
                        SquareCell previous = processed[r][c+1];
                        rightZeros += previous.zeroRight;
                    }
                    if(r+1 < matrix.length){
                        SquareCell previous = processed[r+1][c];
                        belowZeros += previous.zeroBelow;
                    }
                }
                processed[r][c] = new SquareCell(rightZeros, belowZeros)
;            }
        }
        return processed;
    }

    private static SubSquare findSubSquareWithSize(SquareCell[][] matrix, int squareSize) {
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
    private static boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col+size-1];
        SquareCell bottomLeft = matrix[row+size-1][col];

        if(topLeft.zeroRight < size || topLeft.zeroBelow < size ||
        topRight.zeroBelow < size || bottomLeft.zeroRight < size){
            return false;
        }
        return true;
    }
}
class SquareCell {
    int zeroRight = 0;
    int zeroBelow = 0;

    public SquareCell(int zeroRight, int zeroBelow) {
        this.zeroRight = zeroRight;
        this.zeroBelow = zeroBelow;
    }
}
