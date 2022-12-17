package basis.solution.missingpositive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingPositive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(2);
        System.out.println(findMissingPositive(list));
    }
    static int findMissingPositive(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            while(list.get(i) > 0 && list.get(i) <= list.size()
//                    && list.get(list.get(i)-1)!= list.get(i) ){
                    && (i+1)!= list.get(i) ){
                Collections.swap(list, i, list.get(i)-1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != i+1){
                return i+1;
            }
        }
        return list.size() +1 ;
    }
}
