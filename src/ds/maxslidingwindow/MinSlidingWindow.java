package ds.maxslidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

class MinSlidingWindow {
    public static void main(String[] args) {
        solve(arr, windowSize);
    }
    static int[] arr = {1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6};
    static int windowSize = 3;
    static void solve(int[] arr, int windowSize){
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, arr[0]));
        for (int i = 0; i < arr.length; i++) {
            while(! deque.isEmpty() && deque.peekLast().value >= arr[i]){
                deque.pollLast();
            }
            if(! deque.isEmpty() && deque.peekFirst().idx <= i-windowSize){
                deque.pollFirst();
            }
            deque.add(new Node(i, arr[i]));
            System.out.print(deque.peekFirst() + " ");
        }

    }
}
class Node{
    int idx;
    int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
