package recur.parentheses;

import java.util.ArrayList;
import java.util.List;

class Parentheses {
    public static void main(String[] args) {
        List<String> parentheses = parentheses(3, 3, "");
        parentheses.forEach(System.out::println);
    }
    static List<String> parentheses(int left, int right, String parentheses){
        List<String> solutions = new ArrayList<>();
        if(left==0 && right==0){
            solutions.add(parentheses);
            return solutions;
        }
        if(left>0){
            List<String> leftP = parentheses(left - 1,right, parentheses + "(");
            solutions.addAll(leftP);
        }
        if(left<right){
            List<String> rightP = parentheses(left,right - 1, parentheses + ")");
            solutions.addAll(rightP);
        }

        return solutions;
    }
}
