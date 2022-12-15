package ds.stack.popballoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PopBalloon2 {
    public static void main(String[] args) {
        List<Integer> balloons = new ArrayList<>();
        balloons.add(3);
        balloons.add(2);
        balloons.add(1);
        balloons.add(-3);
        balloons.add(-1);
        solve(balloons);
    }
    static void solve(List<Integer> balloons){
        int remain = balloons.size();
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(balloons.get(0));

        while(stack.size() > 0){
            Integer add = stack.pop();
            System.out.print(start + " ");
            balloons.remove(balloons.get(start));
            int nextIdx = (start + add) % remain;
            if(nextIdx < 0) nextIdx+=remain;
            start = nextIdx;
            stack.push(balloons.get(start));
        }
    }
}
