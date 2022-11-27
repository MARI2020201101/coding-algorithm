package recur.palindrome;

import java.util.ArrayList;
import java.util.List;

class Palindrome {
    public static void main(String[] args) {
        String str = "0204451881";
        List<List<String>> palindrome = palindrome(str, 0);
        palindrome.forEach(System.out::println);
    }
    static List<List<String>> palindrome(String str, int offset){
        List<List<String>> solutions = new ArrayList<>();
        if(offset>=str.length()){
            solutions.add(new ArrayList<>());
            return solutions;
        }

        for (int i = offset + 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            if(isPalindrome(prefix)){
                List<List<String>> lists = palindrome(str, offset + 1);
                for (List<String> list : lists) {
                    List<String> solution = new ArrayList<>();
                    solution.addAll(list);
                    solution.add(prefix);
                    solutions.add(solution);
                }
            }
        }
        return solutions;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
