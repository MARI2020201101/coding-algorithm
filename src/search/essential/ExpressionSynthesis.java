package search.essential;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class ExpressionSynthesis {
    static boolean expressionSynthesis(List<Integer> digits, int target){
        List<Character> operators = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();
        return directedExpressionSynthesis(digits, target, 0, 0, operands, operators);
    }

    private static boolean directedExpressionSynthesis(List<Integer> digits, int target, int currentTerm, int offset, List<Integer> operands, List<Character> operators) {
        currentTerm = currentTerm*10 + digits.get(offset);
        if(offset == digits.size()-1){
            operands.add(currentTerm);
            if(evaluate(operands, operators) == target){
                return true;
            }
            operands.remove(currentTerm);
            return false;
        }
        if(directedExpressionSynthesis(digits, target, currentTerm, offset+1, operands, operators)) return true;

        operands.add(currentTerm);
        operators.add('*');
        if(directedExpressionSynthesis(digits, target, 0, offset+1, operands, operators)) return true;
        operands.remove(operands.size()-1);
        operators.remove(operators.size()-1);

        operands.add(currentTerm);
        if(target - evaluate(operands, operators) <= remainingInt(digits, offset+1)){
            operators.add('+');
            if(directedExpressionSynthesis(digits, target, 0, offset+1, operands, operators)) return true;
            operators.remove(operators.size()-1);
        }
        operands.remove(operands.size()-1);

        return false;
    }

    private static int remainingInt(List<Integer> digits, int idx) {
        int val = 0;
        for (int i = 0; i < digits.size(); i++) {
            val = val *10 + digits.get(i);
        }
        return val;
    }

    private static int evaluate(List<Integer> operands, List<Character> operators) {
        Deque<Integer> intermediateOperands = new LinkedList<>();
        int operandIdx = 0;
        intermediateOperands.addFirst(operands.get(operandIdx++));
        for (char oper : operators){
            if(oper == '*'){
                intermediateOperands.addFirst(intermediateOperands.removeFirst() * operands.get(operandIdx++));
            }else{
                intermediateOperands.addFirst(operands.get(operandIdx++));
            }
        }
        int sum = 0;
        while(! intermediateOperands.isEmpty()){
            sum+=intermediateOperands.removeFirst();
        }
        return sum;
    }
}
