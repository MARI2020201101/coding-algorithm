package xsolution;

import java.util.Arrays;

class ShortestSuperSequence {
    public static void main(String[] args) {
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        System.out.println(shortestSuperSequence(big,small));
    }
    static Range shortestSuperSequence(int[] big, int[] small){
        int[] closers = new int[big.length];
        int bestStart = -1;
        int bestEnd = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < small.length; i++) {
            int next = -1;
            for (int j = big.length-1; j >=0 ; j--) {
                if(big[j] == small[i]){
                    next = j;
                }
                if(next== -1 || (closers[j]!=-1 && closers[j] < next)){
                    closers[j]=next;
                }

            }
        }
        System.out.println(Arrays.toString(closers));
        for (int i = 0; i < closers.length; i++) {
            if(closers[i] == -1) continue;
            int nextD =Math.min(distance, closers[i] - i);
            if(nextD!=distance){
                distance = nextD;
                bestStart = i;
                bestEnd = closers[i];
            }
        }
        return new Range(bestStart, bestEnd);
    }
}
class Range{
    int startIdx;
    int endIdx;

    public Range(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    public String toString() {
        return "Range{" +
                "startIdx=" + startIdx +
                ", endIdx=" + endIdx +
                '}';
    }
}