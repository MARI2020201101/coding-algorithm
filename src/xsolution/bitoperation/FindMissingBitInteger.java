package xsolution.bitoperation;

import java.util.ArrayList;
import java.util.List;

class FindMissingBitInteger {
    static int MAX_BIT_COUNT = 8;
    public static void main(String[] args) {
        int n = 15;
        int missing = 7;
        int bitCounts = MAX_BIT_COUNT;
        System.out.println(findMissingBitInteger(initSampleBits(n, missing), bitCounts));
    }

    static List<String> initSampleBits(int n, int missing){
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if(i != missing){
                String bits = Integer.toBinaryString(i);
                for (int j = 0; j < MAX_BIT_COUNT - bits.length(); j++) {
                    bits = "0" + bits;
                }
                list.add(bits);
            }
        }
        list.forEach(System.out::println);
        return list;
    }
    static int findMissingBitInteger(List<String> lists, int bitCounts){
        if(bitCounts == 0) {
            return 0;
        }
        List<String> suffixZero = new ArrayList<>();
        List<String> suffixOne = new ArrayList<>();

        for (String s : lists){
            Integer lastBit = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1) - '0'));
            if(lastBit == 0){
                suffixZero.add(s.substring(0,s.length()-1));
            }else{
                suffixOne.add(s.substring(0,s.length()-1));
            }
        }

        if(suffixZero.size() <= suffixOne.size()){
        //짝수
            int v = findMissingBitInteger(suffixZero, bitCounts - 1);
            return (v << 1) | 0;
        }else{
        //홀수
            int v = findMissingBitInteger(suffixOne, bitCounts - 1);
            return (v << 1) | 1;
        }
    }
}
