package recur.permutation;

import java.util.ArrayList;
import java.util.List;

class NextArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(0);
        System.out.println(nextArr(list));
    }
    static List<Integer> nextArr(List<Integer> arr){
        int swapPoint = arr.size()-1;
        while(swapPoint > 0 && arr.get(swapPoint) < arr.get(swapPoint-1)){
            swapPoint--; // 감소순열이 아닌 시점
        }
        swapPoint--;
        int smallestLargerThanSwapPoint = arr.size()-1;
        while (swapPoint < smallestLargerThanSwapPoint && arr.get(smallestLargerThanSwapPoint) > arr.get(swapPoint)){
            smallestLargerThanSwapPoint--;
        }
        smallestLargerThanSwapPoint--;
        Integer tmp = arr.get(swapPoint);
        arr.set(swapPoint, arr.get(smallestLargerThanSwapPoint));
        arr.set(smallestLargerThanSwapPoint, tmp);

        for (int i = swapPoint+1, j = arr.size()-1; i <= j && i < arr.size(); i++,j--) {
            Integer tmpVal = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmpVal);
        }
        return arr;
    }
}
