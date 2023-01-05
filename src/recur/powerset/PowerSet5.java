package recur.powerset;

import java.util.*;

class PowerSet5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Set<Integer>> powerset = powerset(list);
        powerset.forEach(System.out::println);
    }
    static List<Set<Integer>> powerset(List<Integer> list){
        HashSet<Integer> hashSet = new HashSet<>();
        return powerset(list, hashSet, 0, list.size());
    }

    private static List<Set<Integer>> powerset(List<Integer> list, HashSet<Integer> curr, int index, int size) {
        List<Set<Integer>> solutions = new ArrayList<>();
        if(index >= size){
            solutions.add(new HashSet<>(curr));
            return solutions;
        }
        Integer element = list.get(index);
        curr.add(element);
        List<Set<Integer>> added = powerset(list, curr, index + 1, size);
        curr.remove(element);
        List<Set<Integer>> nonAdded = powerset(list, curr, index + 1, size);
        solutions.addAll(added);
        solutions.addAll(nonAdded);
        return solutions;
    }
}
