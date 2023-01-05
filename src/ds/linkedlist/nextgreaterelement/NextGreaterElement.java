package ds.linkedlist.nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nge(arr)));
    }
    static int[] arr = {2,1,2,4,3};
    static int[] nge(int[] arr){
        int[] nges = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            int nge = -1;
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nge=stack.peek();
            }
            nges[i] = nge;
            stack.push(arr[i]);
        }
        return nges;
    }
}
