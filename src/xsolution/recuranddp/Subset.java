package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.List;

class Subset {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<List<Integer>> lists = subset(list, 0);
        lists.forEach(System.out::println);
    }
    static List<List<Integer>> subset(List<Integer> list, int index){
        List<List<Integer>> result = new ArrayList<>();
        if(index == list.size()){
            result.add(new ArrayList<>());
            return result;
        }
        Integer element = list.get(index);
        List<List<Integer>> subsets = subset(list, index + 1);
        for (List<Integer> subset : subsets) {
            List<Integer> nextSubset = new ArrayList<>();
            nextSubset.add(element);
            nextSubset.addAll(subset);
            result.add(nextSubset);
        }
        result.addAll(subsets);
        return result;
    }
}
