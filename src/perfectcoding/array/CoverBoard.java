package perfectcoding.array;

class CoverBoard {
    static int[][][] coverType = {
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}},
    };

    static boolean set(int[][] board, int row, int col, int type, int delta){
        boolean ok = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + coverType[type][i][0];
            int nextCol = col + coverType[type][i][1];
            if(nextRow < 0 || nextCol < 0 || nextRow >= board.length || nextCol >= board[0].length){
                ok = false;
            }
            else if(board[nextRow][nextCol] + delta > 1){
                ok = false;
            }
        }
        return ok;
    }

    static int cover(int[][] board){
        int row = -1;
        int col = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    break;
                }
                if(row != -1) break;
            }
        }
        if(row == -1) return 1;
        int ret = 0;
        for (int type = 0; type < 4; type++) {
            if(set(board, row, col, type, 1)){
                ret += cover(board);
                set(board, row, col, type, -1);
            }
        }
        return ret;
    }
}
