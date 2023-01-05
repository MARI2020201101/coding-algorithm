package search.leetcode.validparentheses;

class IsValidParentheses {
    static boolean isValidParentheses(String str){
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') left++;
            else left--;

            if(left < 0) return false;
        }
        return left==0;
    }
}
