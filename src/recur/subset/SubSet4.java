package recur.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubSet4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(subset(list,2));
    }
    static List<List<Integer>> subset(List<Integer> list, int k){
        List<Integer> set = new ArrayList<>();
        return subset(list, k,0, set);
    }

    private static List<List<Integer>> subset(List<Integer> list, int k, int index, List<Integer> set) {
        List<List<Integer>> subset = new ArrayList<>();
        if(set.size() == k){
            subset.add(new ArrayList<>(set));
            return subset;
        }
        int remainSize = k - set.size();
        int n = list.size();
        for (int i = index; i < n && remainSize < n-i+1; i++) {
            Integer element = list.get(i);
            set.add(element);
            List<List<Integer>> sets = subset(list, k, index + 1, set);
            subset.addAll(sets);
            set.remove(set.size()-1);
        }
        return subset;
    }
}
