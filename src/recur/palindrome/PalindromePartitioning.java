package recur.palindrome;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    static List<List<String>> palindromePartitioning(String input){
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        __palindromePartitioning(input, 0, list, result);
        return result;
    }

    private static void __palindromePartitioning(String input, int offset, List<String> partial
            , List<List<String>> result) {
        if(offset == input.length()){
            result.add(new ArrayList<>(partial));
            return;
        }
        for (int i = offset+1; i <= input.length() ; i++) {
            String prefix = input.substring(offset, i);
            if(isPalindrome(prefix)){
                partial.add(prefix);
                __palindromePartitioning(input, i ,partial, result);
                partial.remove(prefix);
            }
        }
    }

    private static boolean isPalindrome(String prefix) {
        for (int i = 0,j=prefix.length()-1; i < prefix.length() && j>i; i++,j--) {
            if(prefix.charAt(i)!=prefix.charAt(j)) return false;
        }
        return true;
    }
}
