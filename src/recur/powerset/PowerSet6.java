package recur.powerset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PowerSet6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Set<Integer>> powerset = powerSet(list);
        powerset.forEach(System.out::println);
    }
    static List<Set<Integer>> powerSet(List<Integer> list){
        int totalSet = 1 << list.size();
        List<Set<Integer>> powerset = new ArrayList<>();
        for (int i = 0; i < totalSet; i++) {
            Set<Integer> set = new HashSet<>();
            int x = i;
            while(x!=0){
                int lastBit = x & -x;
                int v = list.get((int) (Math.log(lastBit) / Math.log(2)));
                set.add(v);
                x&=(x-1);
            }
            powerset.add(set);
        }
        return powerset;
    }
}
