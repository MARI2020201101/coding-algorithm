package search.essential;

import java.util.List;

class RotateArr {
    static void rotate(int rotateAmount, List<Integer> A){
        rotateAmount%=A.size();
        if(rotateAmount == 0) return;
        int cycleCount = gcd(A.size(), rotateAmount);
        int cycleLen = A.size() /  cycleCount;
        for (int c = 0; c < cycleCount; c++) {
            applyCyclicPermutation(rotateAmount, c, cycleLen, A);
        }
    }

    private static void applyCyclicPermutation(int rotateAmount, int offset, int cycleLen, List<Integer> A) {
        int tmp = A.get(offset);
        for (int i =1; i < cycleLen ; i++){
            int val = A.get((offset + i * rotateAmount) % A.size());
            A.set((offset + i * rotateAmount) % A.size(), tmp);
            tmp = val;
        }
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        else if(a == 0) return b;
        else if(b > a) return gcd(b,a);
        return gcd(b, a%b);
    }
}
