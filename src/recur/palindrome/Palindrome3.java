package recur.palindrome;

import java.util.ArrayList;
import java.util.List;

class Palindrome3 {
    public static void main(String[] args) {
        List<List<String>> palindrome = palindrome("0204451881");
        palindrome.forEach(System.out::println);
    }
    static List<List<String>> palindrome(String input) {
        List<List<String>> palindromes = new ArrayList<>();
        List<String> palindrome = new ArrayList<>();
        palindrome(input, 0, input.length(), palindromes, palindrome);
        return palindromes;
    }

    private static void palindrome(String input, int offset, int n, List<List<String>> palindromes, List<String> list) {
        if(offset >= n){
            palindromes.add(new ArrayList<>(list));
            return;
        }
        for (int i = offset+1; i <= n; i++) {
            String left = input.substring(offset, i);
            if(isPalindrome(left)){
                list.add(left);
                palindrome(input, offset+1, n, palindromes, list);
                list.remove(left);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        return reverse.equals(str);
    }

}
