package recur.graybits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class GrayCodes3 {
    public static void main(String[] args) {
        System.out.println(graycodes(3));
    }
    static List<Integer> graycodes(int numbits){
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        HashSet<Integer> set = new HashSet<>(Arrays.asList(0));
        graycodes(numbits, set, result);
        return result;
    }

    private static boolean graycodes(int numbits, HashSet<Integer> set, List<Integer> result) {
        if(result.size() == (1<<numbits)){
            return differsOneBits(result.get(0), result.get(result.size()-1));
        }
        for (int i = 0; i < numbits; i++) {
            int prevCOde = result.get(result.size()-1);
            int candidate = prevCOde^(1<<i);
            if(! set.contains(candidate)){
                set.add(candidate);
                result.add(candidate);
                if(graycodes(numbits, set, result)){
                    return true;
                }
                set.remove(candidate);
                result.remove(result.size()-1);
            }
        }
        return false;
    }

    private static boolean differsOneBits(Integer x, Integer y) {
        int bitdiffer = x^y;
        return (bitdiffer &(bitdiffer-1)) == 0 && bitdiffer!=0;
    }
}
