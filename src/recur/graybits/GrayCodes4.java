package recur.graybits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class GrayCodes4 {
    static List<Integer> grayCode(int numBits){
        List<Integer> result = new ArrayList<>();
        __grayCode(numBits, new HashSet<Integer>(), result);
        return  result;
    }

    private static boolean __grayCode(int numBits, HashSet<Integer> history, List<Integer> result) {
        if(result.size()== 1<<numBits){
            return differsByOneBit(result.get(0), result.get(result.size()-1));
        }
        for (int i = 0; i < numBits; i++) {
            int prevCode = result.get(result.size()-1);
            int candNext = prevCode ^ (1 << i);
            if(! history.contains(candNext)){
                history.add(candNext);
                result.add(candNext);
                if(__grayCode(numBits, history, result)) return true;
                history.remove(candNext);
                history.remove(candNext);
            }
        }
        return false;
    }

    private static boolean differsByOneBit(Integer x, Integer y) {
        int bitDiffer = x ^ y ;
        return bitDiffer!=0 && (bitDiffer&(bitDiffer-1))==0;
    }
}
