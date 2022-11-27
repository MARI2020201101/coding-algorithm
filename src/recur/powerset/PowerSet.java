package recur.powerset;

import java.util.ArrayList;
import java.util.List;

class PowerSet {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        List<List<Integer>> powerSet = powerSet(0, set);
        powerSet.forEach(System.out::println);
    }
    static List<List<Integer>> powerSet(int n, List<Integer> set){
        List<List<Integer>> solutions = new ArrayList<>();
        if(n == set.size()){
            List<Integer> list = new ArrayList<>();
            solutions.add(list);
            return solutions;
        }

        List<List<Integer>> lists = powerSet(n + 1, set);
        solutions.addAll(lists);
        Integer item = set.get(n);
        for (List<Integer> list : lists) {
            List<Integer> include = new ArrayList<>();
            include.add(item);
            include.addAll(list);
            solutions.add(include);
        }
        return solutions;
    }
}
