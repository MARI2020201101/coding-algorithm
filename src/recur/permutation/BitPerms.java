package recur.permutation;

import java.util.ArrayList;
import java.util.List;

class BitPerms {
    public static void main(String[] args) {
        List<List<Integer>> lists = create(5);
        lists.forEach(System.out::println);
    }
    static List<List<Integer>> create(int n){
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            int x = i;
            List<Integer> list = new ArrayList<>();
            for (int j = n-1; j >= 0; j--) {
                int bit = 1 << j;
                if((x & bit)>=1){
                    list.add(1);
                }else{
                    list.add(0);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
