package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.List;

class Permutation2 {
    public static void main(String[] args) {
        String str = "abcd";
        List<String> perms = perms(str);
        perms.forEach(System.out::println);
    }
    static List<String> perms(String str) {
        int len=str.length();
        List<String> result = new ArrayList<>();
        if(len == 0){
            result.add("");
            return result;
        }


        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0,i);
            String right = str.substring(i+1, len);
            List<String> perms = perms(left+right);
            for (String perm : perms) {
                result.add(str.charAt(i) + perm);
            }
        }
        return result;
    }
}
