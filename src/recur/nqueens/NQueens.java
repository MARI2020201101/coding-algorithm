package recur.nqueens;

import java.util.ArrayList;
import java.util.List;

class NQueens {

    public static void main(String[] args) {
        List<List<Integer>> lists = nQueens(0, 8, new ArrayList<>());
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> nQueens(int i, int n, List<Integer> chess){
        if(i>=n) {
            List<List<Integer>> solution = new ArrayList<>();
            solution.add(chess);
            return solution;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            chess.add(idx);
            if(canAppend(chess, idx, i)){
                lists = nQueens(i + 1, n, chess);
            }
        }
        return lists;
    }

    private static boolean canAppend(List<Integer> chess, int idx, int j) {
        for (int i = 0; i < idx; i++) {
            int diff = Math.abs(chess.get(i) - idx);
            if(diff == 0) return false;
            if(Math.abs(i-j) == diff) return false;
        }
        return true;
    }
}
