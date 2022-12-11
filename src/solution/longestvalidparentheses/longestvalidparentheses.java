package solution.longestvalidparentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class LongestValidParentheses {
    static int longestValidParentheses(String s){
        int maxLength = 0;
        int end = -1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                deque.addFirst(i);
            }else if(deque.isEmpty()){
                end = i;
            }else{
                deque.pollFirst();
                int start = deque.isEmpty() ? end : deque.peekFirst();
                maxLength = Math.max(maxLength, i-start);
            }
        }
        return maxLength;
    }
}
