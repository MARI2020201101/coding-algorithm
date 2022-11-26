package recur.hanoi;

import java.util.*;

class Hanoi {
    public static void main(String[] args) {
        List<Deque<Integer>> rings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            rings.add(new ArrayDeque<>());
        }
        int count = 5;
        for (int i = count; i > 0; i--) {
            rings.get(0).addFirst(i);
        }

        List<List<Integer>> hanoi = hanoi(count, rings, 0, 1, 2);
        hanoi.forEach(System.out::println);
    }
    static List<List<Integer>> hanoi(int count, List<Deque<Integer>> rings, int from, int to, int buffer){
        List<List<Integer>> solution = new ArrayList<>();
        if(count > 0){
            hanoi(count-1, rings, from, buffer, to);
            rings.get(to).addFirst(rings.get(from).removeFirst());
            solution.add(Arrays.asList(from,to));
            hanoi(count-1, rings, buffer, to, from);
        }
        return solution;
    }
}
