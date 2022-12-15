package ds.stack.popballoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PopBalloon3 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,-3,-1};
    }
    static void solve(boolean[] check, int[] arr){
       Stack<Integer> stack = new Stack<>();
       stack.push(0);

       while(! stack.isEmpty()){
           Integer idx = stack.pop();
           int next = arr[idx];
           int i = 0;
           int target = 0;
           while(i!=next){
               if(! check[i+idx]) i++;
           }

       }
    }
}
