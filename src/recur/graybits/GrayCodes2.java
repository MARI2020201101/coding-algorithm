package recur.graybits;

import java.util.ArrayList;
import java.util.List;

class GrayCodes2 {
    public static void main(String[] args) {
        List<List<Integer>> graycodes = graycodes(3);
        graycodes.forEach(System.out::println);
    }
    static List<List<Integer>> graycodes(int N){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return graycodes(N, 0, list);
    }

    private static List<List<Integer>> graycodes(int N, int i, List<Integer> list) {
        List<List<Integer>> solutions = new ArrayList<>();
        if(list.size() == (1<<N)){
            solutions.add(new ArrayList<>(list));
            return solutions;
        }
        Integer last = list.get(list.size() - 1);
        int nextZero = last << 1 | 0;
        int nextOne = last << 1 | 1;
        list.add(nextZero);
        List<List<Integer>> addedZero = graycodes(N, i + 1, list);
        list.remove(nextZero);
        list.add(nextOne);
        List<List<Integer>> addedOne = graycodes(N, i+1, list);
        solutions.addAll(addedZero);
        solutions.addAll(addedOne);
        return solutions;
    }
}
