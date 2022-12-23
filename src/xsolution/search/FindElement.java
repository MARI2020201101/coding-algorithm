package xsolution.search;

class FindElement {
    static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x){
        if(!origin.inBounds(matrix) || !dest.inBounds(matrix)) return null;

        if(matrix[origin.row][origin.column] == x){
            return origin;
        }else if(! origin.isBefore(dest)){
            return null;
        }
        Coordinate start = Coordinate.cloneThis(origin);
        int diagDest = Math.min(dest.row - origin.row, dest.column- origin.column);
        Coordinate end = new Coordinate(start.row + diagDest, start.column+ diagDest);
        Coordinate p = new Coordinate(0,0);

        while(start.isBefore(end)){
            p.setToAverage(start, end);
            if(x > matrix[p.row][p.column]){
                start.row = p.row+1;
                start.column = p.column+1;
            }else{
                end.row = p.row-1;
                end.column = p.column-1;
            }
        }
        return partitionAndSearch(matrix, origin, dest, start, x);

    }

    private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x) {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column-1);
        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRightDest = new Coordinate(pivot.row-1, dest.column);

        Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);
        if(lowerLeft ==null){
            return findElement(matrix, upperRightOrigin, upperRightDest, x);
        }
        return lowerLeft;
    }
}
class Coordinate{
    int row;
    int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public static Coordinate cloneThis(Coordinate origin){
        return new Coordinate(origin.row, origin.column);
    }

    public boolean inBounds(int[][] matrix){
        return row >=0 && column >=0 && row < matrix.length && column < matrix[0].length;
    }
    public boolean isBefore(Coordinate p){
        return row <= p.row && column <= p.column;
    }
    public void setToAverage(Coordinate min, Coordinate max){
        row = (min.row+ max.row) /2;
        column = (min.column + max.column) /2;
    }
}