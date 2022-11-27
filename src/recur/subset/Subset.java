package recur.subset;

import java.util.ArrayList;
import java.util.List;

class Subset {

    public static void main(String[] args) {
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        subset(0, 2, set, solution, solutions);
        solutions.forEach(System.out::println);
    }
    static void subset(int n, int k, List<Integer> set ,List<Integer> solution, List<List<Integer>> solutions){
        if(solution.size() == k){
            solutions.add(new ArrayList<>(solution));
            return;
        }
        for (int i = n; i < set.size(); i++) {
            Integer item = set.get(i);
            solution.add(item);
            subset(n+1, k, set, solution, solutions);
            solution.remove(solution.size()-1);
            subset(n+1, k, set, solution, solutions);
        }
    }
}
