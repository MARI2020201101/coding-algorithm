package basis.basis02.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutation2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        Set<Integer> contained = new HashSet<>();
        List<List<Integer>> perms = perms(0, list, contained);
        perms.forEach(System.out::println);
    }
    static List<List<Integer>> perms(int n, List<Integer> list, Set<Integer> contained){
        List<List<Integer>> solutions = new ArrayList<>();
        if(n == list.size()){
            solutions.add(new ArrayList<>());
            return solutions;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer item = list.get(i);
            if(contained.contains(item)) continue;
            contained.add(item);
            List<List<Integer>> lists = perms(n + 1, list, contained);
            contained.remove(item);
            for (int j = 0; j < lists.size(); j++) {
                List<Integer> solution = lists.get(j);
                solution.add(item);
            }
            solutions.addAll(lists);
        }

        return solutions;
    }
}
