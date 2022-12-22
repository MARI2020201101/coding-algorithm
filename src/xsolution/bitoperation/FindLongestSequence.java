package xsolution.bitoperation;

import java.util.ArrayList;
import java.util.List;

class FindLongestSequence {
    public static void main(String[] args) {
        int longestSequence = findLongestSequence(1775);
        System.out.println("longestSequence = " + longestSequence);
    }
    static int findLongestSequence(int n){
        List<Integer> sequences = new ArrayList<>();

        int search = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((n & 1)!=search){
                sequences.add(count);
                search = n&1;
                count=0;
            }
            count++;
            n>>>=1;

        }
        sequences.forEach(s -> System.out.print(s + " "));
        return findLongestSequence(sequences);
    }

    private static int findLongestSequence(List<Integer> sequences) {
        int longestSequence = 0;
        for (int i = 0; i < sequences.size(); i+=2) {
            int zeroCount = sequences.get(i);
            int leftOneCount = i == 0 ? 0 : sequences.get(i-1);
            int rightOneCount = i == sequences.size()-1 ? 0 : sequences.get(i+1);

            int thisSequence = 0;
            if(zeroCount > 1){
                thisSequence = Math.max(leftOneCount, rightOneCount) + 1;
            }else if(zeroCount == 1){
                thisSequence = leftOneCount + 1 + rightOneCount;
            }else{
                thisSequence = Math.max(leftOneCount, rightOneCount);
            }
            longestSequence = Math.max(thisSequence, longestSequence);
        }

        return longestSequence;
    }
}
