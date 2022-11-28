package basis02.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Subset {
    public static void main(String[] args) {
        List<Integer> perms = new ArrayList<>();
        Set<Integer> included = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        List<List<Integer>> permutation = subset(0, perms, included, list);
        permutation.forEach(System.out::println);
    }
    static List<List<Integer>> subset(int n, List<Integer> subsets , Set<Integer> included, List<Integer> list){
        List<List<Integer>> solutions = new ArrayList<>();
        if(n == list.size()){
            solutions.add(new ArrayList<>(subsets));
            return solutions;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer item = list.get(i);
            if(included.contains(item)) continue;
            subsets.add(item);
            included.add(item);
            List<List<Integer>> contained = subset(n + 1, subsets, included, list);
            solutions.addAll(contained);
            included.remove(item);
            subsets.remove(subsets.size()-1);
            List<List<Integer>> notContained = subset(n + 1, subsets, included, list);
            solutions.addAll(notContained);
        }
        return solutions;
    }
}
