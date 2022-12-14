package ds.stack.nextgreaterelement;

import java.util.Stack;

class Nge {
    public static void main(String[] args) {
        int[] arr = {3,5,2,7};
        nge(arr);
    }
    static void nge(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            Integer cand = stack.isEmpty() ? -1 : stack.peek();
            while(! stack.isEmpty() && arr[i] > cand){
                cand=stack.pop();
            }
            System.out.print(cand+ " ");
            stack.push(arr[i]);
        }
    }
}
