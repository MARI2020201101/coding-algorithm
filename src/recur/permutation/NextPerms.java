package recur.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

class NextPerms {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(0);
        List<Integer> next = nextPerm(list);
        System.out.println(next);
    }
    static List<Integer> nextPerm(List<Integer> perm){
        int point = 0;
        System.out.println(perm);
        for (int i = perm.size()-2; i >= 0 ; i--) {
            if(perm.get(i+1) > perm.get(i)) {
                point = i+1;
                break;
            }
        }
        if(point == 0) return null;
        System.out.println("point ="+point);
        int swapPoint = perm.size()-1;
        for (int i = point; i < perm.size(); i++) {
            if(perm.get(i) < perm.get(swapPoint)){
                swapPoint = i;
            }
        }
        System.out.println("swapPoint ="+swapPoint);
        swap(perm, swapPoint, point-1);

        Collections.reverse(perm.subList(point, perm.size()));
        return perm;
    }
}
