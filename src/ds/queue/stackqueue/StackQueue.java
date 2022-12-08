package ds.queue.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

class StackQueue {
    Deque<Integer> enqueue = new ArrayDeque<>();
    Deque<Integer> dequeue = new ArrayDeque<>();

    public void enqueue(int data){
        enqueue.addLast(data);
    }
    public int dequeue(){
        if(dequeue.isEmpty()){
            while(! enqueue.isEmpty()){
                dequeue.addLast(enqueue.pollLast());
            }
        }
        return dequeue.pollLast();
    }
}
