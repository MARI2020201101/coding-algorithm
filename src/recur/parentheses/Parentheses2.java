package recur.parentheses;

import java.util.ArrayList;
import java.util.List;

class Parentheses2 {
    public static void main(String[] args) {
        System.out.println(parentheses(3));
    }
    static List<String> parentheses(int num){
        return parentheses(num, num, "");
    }

    private static List<String> parentheses(int leftNum, int rightNum, String prefix) {
        List<String> parentheses = new ArrayList<>();
        if(leftNum == 0 && rightNum == 0){
            parentheses.add(prefix);
            return parentheses;
        }

        if(leftNum > 0){
            List<String> leftResult = parentheses(leftNum - 1, rightNum, prefix + "(");
            parentheses.addAll(leftResult);
        }
        if(rightNum > leftNum){
            List<String> rightResult = parentheses(leftNum, rightNum-1, prefix+")");
            parentheses.addAll(rightResult);
        }
        return parentheses;
    }
}
