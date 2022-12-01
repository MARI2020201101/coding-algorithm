package dp04.prettystrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrettyStr {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("aaa");
        words.add("bbb");
        words.add("c");
        words.add("d");
        words.add("ee");
        words.add("ff");
        words.add("ggggggg");
        System.out.println(prettyStr(words, 11));
    }
    static int prettyStr(List<String> words, int lineLen){
        int[] minMessiness = new int[words.size()];
        Arrays.fill(minMessiness, Integer.MAX_VALUE);
        int first = lineLen - words.get(0).length();
        minMessiness[0] = first*first;
        for (int i = 1; i < words.size(); i++) {
            int remainLen = lineLen - words.get(i).length();
            minMessiness[i] = minMessiness[i-1] + remainLen*remainLen;
            for (int j = i-1; j >=0 ; j--) {
                remainLen -= (words.get(j).length()+1);
                if(remainLen < 0) break;
                int messinessUntilNow = j-1<0?0:minMessiness[j-1];
                minMessiness[i] = Math.min(minMessiness[i], messinessUntilNow + remainLen*remainLen);
            }
        }
        System.out.println(Arrays.toString(minMessiness));
        return minMessiness[words.size()-1];
    }
}
