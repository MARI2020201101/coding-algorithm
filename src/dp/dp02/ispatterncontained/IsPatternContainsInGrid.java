package dp.dp02.ispatterncontained;

class IsPatternContainsInGrid {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {3,4,5},
                {5,6,7},
        };
        int[] pattern = {1,3,4,6};
        System.out.println(isPatternContained(grid, pattern));
    }
    static int[][] move = {
            {0,1},
            {-1,0},
            {0,-1},
            {1,0}
    };
    static boolean isPatternContained(int[][] grid, int[] pattern){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < move.length; k++) {
                    int nextX = i + move[k][0];
                    int nextY = j + move[k][1];
                    if(! canMove(grid, nextX, nextY, pattern)){
                        break;
                    }
                }
            }
        }
        return true;
    }

    private static boolean canMove(int[][] grid, int nextX, int nextY, int[] pattern) {
        if(nextX<0 || nextY<0 || nextX >= grid.length || nextY >=grid[0].length) return false;
        for (int i = 0; i < pattern.length; i++) {
            if(grid[nextX][nextX]==pattern[i]) return true;
        }
        return false;
    }
}
