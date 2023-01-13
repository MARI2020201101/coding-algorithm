package recur.graybits;

import java.util.ArrayList;
import java.util.List;

class GrayCodes5 {
    static List<Integer> grayCodes(int numbits){
        if(numbits == 0){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<Integer> graycodes = grayCodes(numbits-1);
        int leadingBitOne = 1 << (numbits -1);
        for (int i = graycodes.size()-1; i >=0 ; i--) {
            graycodes.add(leadingBitOne | graycodes.get(i));
        }
        return graycodes;
    }
}
