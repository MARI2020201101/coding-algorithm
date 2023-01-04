package recur.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutation4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> perms = perms(list);
        perms.forEach(System.out::println);
        System.out.println(perms.size());
    }
    static List<List<Integer>> perms(List<Integer> list){
        return perms(list, 0);
    }

    private static List<List<Integer>> perms(List<Integer> list, int k) {
        List<List<Integer>> solutions = new ArrayList<>();
        if(k == list.size()){
            solutions.add(new ArrayList<>(list));
            return solutions;
        }
        int i = k;
//        for (int i = k; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                Collections.swap(list, i,j);
                List<List<Integer>> perms = perms(list, k + 1);
                solutions.addAll(perms);
                Collections.swap(list, i,j);
            }
//        }
        return solutions;
    }
}
