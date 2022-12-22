package xsolution.recuranddp;

import java.util.Stack;

class Hanoi {
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = 1; i <= n; i++) {
            towers[0].stack.add(i);
        }

        towers[0].moveDisks(n, towers[1], towers[2]);
    }
}
class Tower {
    Stack<Integer> stack = new Stack<>();
    int index;
    public Tower(int index){
        this.index = index;
    }
    public void add(Integer element){
        stack.push(element);
    }
    public void moveTopTo(Tower t){
        Integer top = stack.pop();
        t.add(top);
    }
    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n > 0){
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}