package ds.queue.queuewithmax;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class QueueWithMax {
    private Deque<Integer> entries = new ArrayDeque<>();
    private Deque<Integer> maxCandidate = new ArrayDeque<>();


    public void enqueue(int data){
        entries.addLast(data);
        while(! maxCandidate.isEmpty() && maxCandidate.peekLast() < data){
            maxCandidate.pollLast();
        }
        maxCandidate.addLast(data);
    }
    public int max(){
        if(maxCandidate.isEmpty()) return -1;
        return maxCandidate.peekFirst();
    }
}
