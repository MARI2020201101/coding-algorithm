package recur.powerset;

import java.util.ArrayList;
import java.util.List;

class PowerSet2 {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        List<Integer> solution = new ArrayList<>();
        List<List<Integer>> solutions = new ArrayList<>();
        powerSet(0, set, solution, solutions);
        solutions.forEach(System.out::println);
    }
    static void powerSet(int n, List<Integer> set, List<Integer> solution ,List<List<Integer>> solutions){
       if(n == set.size()){
           solutions.add(new ArrayList<>(solution));
           return;
       }
        for (int i = n; i < set.size(); i++) {
            Integer item = set.get(i);
            solution.add(item);
            powerSet(n+1,set, solution,solutions);
            solution.remove(solution.size()-1);
            powerSet(n+1,set, solution,solutions);
        }
    }
}
