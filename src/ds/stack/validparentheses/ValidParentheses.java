package ds.stack.validparentheses;

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        String str = "(()[[]])([])";
        String str2 = "[][]((])";
        System.out.println(solve(str));
        System.out.println(solve(str2));
    }
    static int solve(String str){
        int multiply = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                multiply*=2;
                stack.push('(');
            }
            else if(str.charAt(i) == '['){
                multiply*=3;
                stack.push('[');
            }
            else if(str.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return -1;
                stack.pop();
                result += multiply;
                multiply/=2;
            }else {
                if(stack.isEmpty() || stack.peek() != '[') return -1;
                stack.pop();
                result += multiply;
                multiply/=3;
            }
        }
        if(! stack.isEmpty()) return -1;
        return result;
    }
}
