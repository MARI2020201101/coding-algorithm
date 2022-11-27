package recur.permutation;

import java.util.ArrayList;
import java.util.List;

class Permutation3 {
    public static void main(String[] args) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        perms(1, list, solution);
        solution.forEach(System.out::println);
    }
    static void perms(int n, List<Integer> perms, List<List<Integer>> solution){
        if(n == perms.size()){
            solution.add(new ArrayList<>(perms));
        }

        for (int i = n; i < perms.size(); i++) {
            swap(perms, i,n);
            perms(n+1, perms, solution);
            swap(perms, i,n);
        }
    }

    private static void swap(List<Integer> perms, int i, int j) {
        Integer tmp = perms.get(i);
        perms.set(i, perms.get(j));
        perms.set(j, tmp);
    }
}
