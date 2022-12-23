package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StackBoxes {
    static int stackBoxes(List<Box> boxes){
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.height - o1.height;
            }
        });
        int[] stackMap = new int[boxes.size()];
        return stackBoxes(boxes, null, 0, stackMap);
    }

    private static int stackBoxes(List<Box> boxes, Box bottom, int index, int[] stackMap) {
        if(index >= boxes.size()){
            return 0;
        }
        Box box = boxes.get(index);
        int heightwithBottom = 0;
        if(bottom == null || canStack(box, bottom)){
            if(stackMap[index] == 0){
                stackMap[index] = stackBoxes(boxes, box, index+1, stackMap);
                stackMap[index]+=box.height;
            }
            heightwithBottom = stackMap[index];
        }
        int heightwithoutBottom=stackBoxes(boxes, bottom, index+1, stackMap);
        return Math.max(heightwithoutBottom, heightwithBottom);
    }

    private static boolean canStack(Box box, Box bottom) {
        if(bottom == null) return true;
        return box.height < bottom.height && box.depth < bottom.depth && box.width < bottom.width;
    }


}
class Box {
    int width;
    int depth;
    int height;
}
