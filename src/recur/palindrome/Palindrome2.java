package recur.palindrome;

import java.util.ArrayList;
import java.util.List;

class Palindrome2 {
    public static void main(String[] args) {
        String str = "0204451881";
        List<List<String>> palindrome = palindrome(str);
        palindrome.forEach(System.out::println);
    }
    static List<List<String>> palindrome(String str){
        List<List<String>> solutions = new ArrayList<>();
        if(0==str.length()){
            solutions.add(new ArrayList<>());
            return solutions;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i);
            String remain = str.substring(i+1);

            if(isPalindrome(prefix)){
                List<List<String>> lists = palindrome(remain);
                for (List<String> list : lists) {

                    List<String> solution = new ArrayList<>();
                    solution.add(prefix);
                    solution.addAll(list);
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
