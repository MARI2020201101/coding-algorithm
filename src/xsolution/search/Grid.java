package xsolution.search;

class Grid {
    private boolean[][] grid;
    private Ant ant = new Ant();

    public Grid(){
        grid = new boolean[1][1];
    }
    private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftCol){
        for (int r = 0; r < oldGrid.length; r++) {
            for (int c = 0; c < oldGrid[0].length; c++) {
                newGrid[r+shiftRow][c+shiftCol] = oldGrid[r][c];
            }
        }
    }
    private void ensureFit(Position position){
        int shiftRow = 0;
        int shiftCol = 0;

        int numRows = grid.length;
        if(position.row < 0){
            shiftRow = numRows;
            numRows*=2;
        }else if(position.row>=numRows){
            numRows*=2;
        }

        int numCols = grid[0].length;
        if(position.column < 0){
            shiftCol = numCols;
            numCols*=2;
        }else if(position.column>=numCols){
            numCols*=2;
        }

        if(numRows != grid.length || numCols != grid[0].length){
            boolean[][] newGrid = new boolean[numRows][numCols];
            copyWithShift(grid, newGrid, shiftRow, shiftCol);
            ant.adjustPosition(shiftRow, shiftCol);
            grid = newGrid;
        }
    }
    private void flip(Position position){
        int row = position.row;
        int col = position.column;
        grid[row][col] = !grid[row][col];
    }
    public void move(){
        ant.turn(grid[ant.position.row][ant.position.column]);
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }
}
