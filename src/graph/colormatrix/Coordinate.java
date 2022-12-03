package graph.colormatrix;

class Coordinate {
    int x;
    int y;
}
class ColorMatrix{
    public static void main(String[] args) {
        color(matrix,4,5);
        print(matrix);
    }
    static int[][] matrix = {
            {1,0,1,0,0,0,1,1,1,1},
            {0,0,1,0,0,1,0,0,1,1},
            {1,1,1,0,0,1,1,0,1,1},
            {0,1,0,1,1,1,1,0,1,0},
            {1,0,1,0,0,0,0,1,0,0},
            {1,0,1,0,0,1,0,1,1,1},
            {0,0,0,0,1,0,1,0,0,1},
            {1,0,1,0,1,0,1,0,0,0},
            {1,0,1,1,0,0,0,1,1,1},
            {0,0,0,0,0,0,0,1,1,0},
    };
    static int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static void color(int[][] matrix , int x, int y){
        matrix[x][y] = matrix[x][y]==1? 0 : 1;
        for (int[] d : DIRS) {
            if(canMove(matrix,x+d[0], y+d[1], x , y)){
                color(matrix, x+d[0], y+d[1]);
            }
        }
    }

    private static boolean canMove(int[][] matrix ,int nextX, int nextY, int x, int y) {
        return nextX>=0 && nextY >=0 && matrix.length > nextX && matrix[0].length > nextY &&
                matrix[nextX][nextY] != matrix[x][y] ;
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