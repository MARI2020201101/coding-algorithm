package perfectcoding.bitoperation;

import java.util.HashSet;
import java.util.Set;

class PowerSet {
    public static void main(String[] args) {
        char[] set = {'a','b','c','d','e'};
        Set<Set<Character>> powerset = powerset(set);
        powerset.forEach(System.out::println);
    }
    static Set<Set<Character>> powerset(char[] set){
        long subsetNo = (long)Math.pow(2, set.length);

        Set<Set<Character>> subsets = new HashSet<>();

        for (int i = 0; i < subsetNo; i++) {
            Set<Character> subset = new HashSet<>();
            for (int j = 0; j < set.length; j++) {
                if((i & (1<<j))!=0){
                    subset.add(set[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
