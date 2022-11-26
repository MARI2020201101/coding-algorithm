package recur.nqueens;

import java.util.ArrayList;
import java.util.List;

class NQueens2 {
    public static void main(String[] args) {
        List<List<Integer>> solutions = new ArrayList<>();
        nQueens(8, new ArrayList<>(), solutions);
        solutions.forEach(System.out::println);
    }
    static void nQueens(int n, List<Integer> chess, List<List<Integer>> solutions){
       if(n == chess.size()){
           solutions.add(new ArrayList<>(chess));
       }

        for (int i = 1; i <= n; i++) {
            chess.add(i);
            if(checkAttackable(chess)){
                nQueens(n, chess, solutions);
            }
            chess.remove(chess.size()-1);
        }
    }

    private static boolean checkAttackable(List<Integer> chess) {
        int j = chess.size() - 1;
        for (int i = 0; i < j; i++) {
            int diff = Math.abs(chess.get(i) - chess.get(j));
            if(diff == 0 || j-i == diff){
                return false;
            }
        }
        return true;
    }
}
