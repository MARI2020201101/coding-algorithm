package recur.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubSet3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(subset(list,2));
    }
    static List<Set<Integer>> subset(List<Integer> list, int k){
        Set<Integer> set = new HashSet<>();
        return subset(list, k,0, set);
    }

    private static List<Set<Integer>> subset(List<Integer> list, int k, int index, Set<Integer> set) {
        List<Set<Integer>> subset = new ArrayList<>();
        if(set.size() == k){
            subset.add(new HashSet<>(set));
            return subset;
        }
        int remainSize = k - set.size();
        int n = list.size();
        for (int i = index; i < n && remainSize < n-i+1; i++) {
            Integer element = list.get(i);
            set.add(element);
            List<Set<Integer>> sets = subset(list, k, index + 1, set);
            subset.addAll(sets);
            set.remove(element);
        }
        return subset;
    }
}
