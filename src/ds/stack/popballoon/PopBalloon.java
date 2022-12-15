package ds.stack.popballoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PopBalloon {
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
        int remain = 5;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, balloons.get(0)});
        while(! stack.isEmpty()){
            int[] balloon = stack.pop();
            remain--;
            balloons.remove(balloons.get(balloon[0]));
            System.out.print(balloon[0] + " ");
            int nextIdx = (balloon[0] + balloon[1]) % remain;
            stack.push(new int[]{nextIdx, balloons.get(nextIdx)});
        }
    }
}
