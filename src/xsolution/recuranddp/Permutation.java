package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.List;

class Permutation {
    public static void main(String[] args) {
        String str = "abcd";
        List<String> perms = perms(str);
        perms.forEach(System.out::println);
    }
    static List<String> perms(String str){
        List<String> strs = new ArrayList<>();
        if(str.length()==0){
            strs.add("");
            return strs;
        }

        char first = str.charAt(0);
        String remain = str.substring(1);
        List<String> perms = perms(remain);
        for (int i = 0; i < perms.size(); i++) {
            String s = perms.get(i);
            for (int idx = 0; idx <= s.length() ; idx++){
                String inserted = insertChar(idx, first, s);
                strs.add(inserted);
            }
        }
        return strs;
    }

    private static String insertChar(int idx, char first, String target) {
        String left = target.substring(0,idx);
        String right = target.substring(idx);
        return left + first + right;
    }
}
