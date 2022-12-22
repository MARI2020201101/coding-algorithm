package xsolution.bitoperation;

import java.util.ArrayList;
import java.util.List;

class FindLongestSequence2 {
    public static void main(String[] args) {
        int longestSequence = findLongestSequence(1775);
        System.out.println("longestSequence = " + longestSequence);
    }
    static int findLongestSequence(int n){
       int currentLength = 0;
       int previousLength = 0;
       int longestSequence = 0;
       int mask  =  1<<2;
       while(n!=0){
           if((n & 1)==1){
               currentLength++;
           }else{
               if((n & mask)==0){
                   previousLength = 0;
               }else{
                   previousLength = currentLength;
               }
               currentLength = 0;
           }
           n>>>=1;
           longestSequence = Math.max(longestSequence, currentLength + 1 + previousLength);
       }
       return longestSequence;
    }

}
