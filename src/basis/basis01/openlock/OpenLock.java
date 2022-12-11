package basis.basis01.openlock;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class OpenLock {
    static Queue<String> queue = new PriorityQueue<>();
    static Set<String> deadEnds = new HashSet<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(calculate("0007"));
    }
    static String minus(String str, int index){
        char c = str.charAt(index);
        String left = str.substring(0, index);
        String right = str.substring(index + 1);
        int i = Integer.parseInt(String.valueOf(c));
        String next = i-1 == -1 ? "9" : String.valueOf(i+1);
        return left + next + right;
    }
    static String plus(String str, int index){
        char c = str.charAt(index);
        String left = str.substring(0, index);
        String right = str.substring(index + 1);
        int i = Integer.parseInt(String.valueOf(c));
        String next = i+1 == 10 ? "0" : String.valueOf(i+1);
        return left + next + right;
    }

    static int calculate(String target){
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if(curr.equals(target)) return step;

                for (int j = 0; j < 4; j++) {
                    String plus = plus(curr, j);
                    String minus = minus(curr, j);
                    System.out.println(String.format("plus= "+ plus + " , minus="+minus));
                    if(! visited.contains(plus)){
                        visited.add(plus);
                        queue.add(plus);
                    }
                    if(! visited.contains(minus)){
                        visited.add(minus);
                        queue.add(minus);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
