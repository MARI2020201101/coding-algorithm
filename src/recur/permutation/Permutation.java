package recur.permutation;

import java.util.ArrayList;
import java.util.List;


class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> perms = perms(0, 0, 4, List.of(2, 3, 5, 7));
        perms.forEach(System.out::println);
    }
    static List<List<Integer>> perms(int count,int idx, int n, List<Integer> lists){
        List<List<Integer>> solution = new ArrayList<>();
        if(count == n){
            solution.add(lists);
            return solution;
        }

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(lists.get(i));
            solution = perms(count + 1, idx + 1, n, lists);
            solution.add(subList);
        }
        return solution;
    }
}
