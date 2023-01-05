package search.leetcode.duplicateandmissing;

import java.util.List;

class DuplicateAndMissing {
    int duplicate;
    int missing;

    public DuplicateAndMissing(int duplicate, int missing) {
        this.duplicate = duplicate;
        this.missing = missing;
    }
    static DuplicateAndMissing findDuplicateMissing(List<Integer> list){
        int missXORdup = 0;
        for (int i = 0; i < list.size(); i++) {
             missXORdup ^= list.get(i) ^ i;
        }
        int differBit = missXORdup & -missXORdup;
        int missOrDup = 0;
        for (int i = 0; i < list.size(); i++) {
            if((i&differBit)!=0){
                missOrDup ^= i;
            }
            if((list.get(i) & differBit)!=0){
                missOrDup ^= list.get(i);
            }
        }
        for (int a : list){
            if(a == missOrDup){
                return new DuplicateAndMissing(missOrDup, missOrDup^missXORdup);
            }
        }
        return new DuplicateAndMissing(missOrDup^missXORdup, missOrDup);
    }
}
