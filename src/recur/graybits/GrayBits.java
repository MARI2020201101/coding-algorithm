package recur.graybits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GrayBits {
    public static void main(String[] args) {
        grayBits(4, new ArrayList<>(), new HashSet<>());
    }
    static boolean grayBits(int bitsNum, List<Integer> solution, Set<Integer> contained){
        if(bitsNum == 0){
            return firstLastIsGrayBits(solution.get(0), solution.get(solution.size()-1));
        }
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < bitsNum; i++) {
            int b = 1 << bitsNum;
            for (int j = 0; j < bitsNum; j++) {
                int next = b ^ (1 << j);
                if(! contained.contains(next)){
                    contained.add(next);
                    solution.add(next);
                    if(grayBits(bitsNum-1, solution, contained)){
                        solutions.add(new ArrayList<>(solution));
                    }
                    solution.remove(solution.size()-1);
                    contained.remove(next);
                }
            }
        }
        solutions.forEach(System.out::println);
        return true;
    }

    private static boolean firstLastIsGrayBits(Integer first, Integer last) {
        int xor = first ^ last;
        return xor!=0 &&(xor & (xor-1))==0;
    }
}
