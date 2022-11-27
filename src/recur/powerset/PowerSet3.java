package recur.powerset;

import java.util.ArrayList;
import java.util.List;

class PowerSet3 {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        List<List<Integer>> powerSet = powerSet(set);
        powerSet.forEach(System.out::println);
    }
    static List<List<Integer>> powerSet(List<Integer> set){
        List<List<Integer>> solutions = new ArrayList<>();
        int size = set.size();
        int count = 1<<size;
        System.out.println("count="+count);
        for (int i = 0; i < count; i++) {
            List<Integer> solution = new ArrayList<>();
            int bit = i;
            while(bit!=0){
                Integer item = set.get((int)(Math.log(bit & -bit)/Math.log(2)));
                solution.add(item);
                bit &= bit-1;
            }
            solutions.add(solution);
        }
        return solutions;
    }
}
