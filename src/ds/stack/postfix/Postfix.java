package ds.stack.postfix;

import java.util.Stack;

class Postfix {
    public static void main(String[] args) {
        String expression = "12+54+*";
        System.out.println(solve(expression));
    }
    static double solve(String expression){
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if(Character.isDigit(expression.charAt(i))){
                double val = Double.parseDouble(String.valueOf(expression.charAt(i) - '0'));
                stack.push(val);
            }else{
                char op = expression.charAt(i);
                Double right = stack.pop();
                Double left = stack.pop();
                double result = calculate(left, right, op);
                stack.push(result);
            }
        }
        return stack.pop();
    }
    private static double calculate(double left, double right, char op){
        switch (op){
            case '+': return left+right;
            case '-': return left-right;
            case '*': return left*right;
            case '/':return left/right;
            default:throw new RuntimeException("Cannot parse Operation");
        }
    }
}

