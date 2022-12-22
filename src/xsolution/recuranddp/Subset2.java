package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.List;

class Subset2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<List<Integer>> subset = subset(list);
        subset.forEach(System.out::println);
    }
    static List<List<Integer>> subset(List<Integer> lists){
        List<List<Integer>> result = new ArrayList<>();
        int max = 1 << lists.size();
        for (int i = 0; i < max; i++) {
            List<Integer> subset = converIntToSet(i, lists);
            result.add(subset);
        }
        return result;
    }

    static private List<Integer> converIntToSet(int k, List<Integer> list) {
        int index = 0;
        List<Integer> subset = new ArrayList<>();
        for (int x = k; x != 0 ; x>>=1) {
            if((x & 1)==1){
                subset.add(list.get(index));
            }
            index++;
        }
        return subset;
    }
}
