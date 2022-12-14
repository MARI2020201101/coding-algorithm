package ds.stack.chemicalformula;

import java.util.Stack;

class ChemicalFormula {
    public static void main(String[] args) {
        System.out.println(solve("H2O"));
    }
    static int solve(String formula){
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if(Character.isDigit(formula.charAt(i))){
                Integer chemical = stack.pop();
                int val = chemical * (formula.charAt(i) - '0');
                total += val;
            }else{
                if(! stack.isEmpty()){
                    Integer chemical = stack.pop();
                    total += chemical;
                }
                stack.push(parseChemical(formula.charAt(i)));
            }
        }
        if(! stack.isEmpty()){
            Integer chemical = stack.pop();
            total += chemical;
        }
        return total;
    }
    static int parseChemical(char c){
        switch (c){
            case 'H': return 1;
            case 'C' : return 12;
            case 'O' : return 16;
            default: return 0;
        }
    }
}
