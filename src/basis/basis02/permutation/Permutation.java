package basis.basis02.permutation;

import java.util.ArrayList;
import java.util.List;

class Permutation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        List<List<Integer>> perms = perms(0, list);
        perms.forEach(System.out::println);
    }
    static List<List<Integer>> perms(int n, List<Integer> list){
        List<List<Integer>> solutions = new ArrayList<>();
        if(n == list.size()){
            solutions.add(new ArrayList<>());
            return solutions;
        }
        Integer item = list.get(n);
        List<List<Integer>> lists = perms(n + 1, list);
//        lists.forEach(System.out::println);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> solution = lists.get(i);
            solution.add(item);
        }

        return lists;
    }
}
