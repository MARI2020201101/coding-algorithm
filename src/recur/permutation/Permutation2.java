package recur.permutation;

import java.util.ArrayList;
import java.util.List;


class Permutation2 {
    public static void main(String[] args) {
        List<List<Integer>> perms = perms(0, 0, List.of(2, 3, 5, 7));
        perms.forEach(System.out::println);
    }
    static List<List<Integer>> perms(int count ,int index, List<Integer> lists){
        if(count == lists.size()){
            List<List<Integer>> perms = new ArrayList<>();
            perms.add(new ArrayList<>());
            return perms;
        }
        List<List<Integer>> perms = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            perms = perms(count + 1, i, lists);
            Integer item = lists.get(i);
            for (List<Integer> perm : perms) {
                perm.add(item);
            }
        }
        return perms;
    }
}
