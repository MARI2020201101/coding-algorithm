package recur.cansum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SelectBinary {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = select(3, list);
        lists.forEach(System.out::println);
    }
    static List<List<Integer>> select(int n , List<Integer> list){
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0) {
            result.add(new ArrayList<>(list));
            return result;
        }
        list.add(0);
        List<List<Integer>> notContain = select(n - 1, list);
        list.remove(list.size()-1);
        list.add(1);
        List<List<Integer>> contain = select(n - 1, list);
        result.addAll(notContain);
        result.addAll(contain);
        return result;
    }
}
