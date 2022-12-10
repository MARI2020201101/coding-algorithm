package heap.sortincreasedecrease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortKIncreaseDecreaseArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(57);
        list.add(131);
        list.add(493);
        list.add(221);
        list.add(294);
        list.add(339);
        list.add(418);
        list.add(452);
        List<List<Integer>> result = sortKIncreaseDecreaseArray(list);
        result.forEach(s-> System.out.print(s +  " "));
    }
     static List<List<Integer>> sortKIncreaseDecreaseArray(List<Integer> list){
         List<List<Integer>> result = new ArrayList<>();
         SubArrayType type = SubArrayType.INCREASING;
         int fromIdx = 0;
         for (int i = 1; i <= list.size();i++) {
             if(i==list.size() ||
                     (list.get(i-1) >= list.get(i) && type == SubArrayType.INCREASING) ||
                     ( list.get(i-1) < list.get(i) && type == SubArrayType.DECREASING)){
                 List<Integer> subArr = list.subList(fromIdx,i);
                 if(type == SubArrayType.DECREASING){
                     Collections.reverse(subArr);
                 }
                 result.add(subArr);
                 fromIdx =i;
                 type = type == SubArrayType.INCREASING ? SubArrayType.DECREASING
                         : SubArrayType.INCREASING;
             }
         }
         return result;
     }
     private static enum SubArrayType {
         INCREASING,
         DECREASING;
     }
}
