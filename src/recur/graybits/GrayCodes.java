package recur.graybits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GrayCodes {
    public static void main(String[] args) {
        List<List<Integer>> grayCodes = grayCodes(4);
        grayCodes.forEach(System.out::println);
    }
    static List<List<Integer>> grayCodes(int bitNum){
        if(bitNum == 0){
            List<List<Integer>> solutions = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(0);
            solutions.add(first);
            return solutions;
        }
        List<List<Integer>> lists = grayCodes(bitNum - 1);
        List<Integer> list = lists.get(lists.size() - 1);
        List<Integer> next = new ArrayList<>();
        next.addAll(list);
        for (int i = list.size()-1; i >=0 ; i--) {
            int digit = 1 << bitNum - 1;
            Integer bit = list.get(i);
            next.add(digit | bit);
        }
        lists.add(next);
        return lists;

    }
}
