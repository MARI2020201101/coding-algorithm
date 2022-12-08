package ds.queue.circlequeue;

import java.util.Arrays;
import java.util.Collections;


class Demo{
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.enqueue(1);
        circleQueue.enqueue(2);
        circleQueue.enqueue(3);
        circleQueue.enqueue(4);
        circleQueue.enqueue(5);
        circleQueue.print();
        circleQueue.enqueue(6);
        circleQueue.print();
        int dequeue = circleQueue.dequeue();
        System.out.println(dequeue);
        circleQueue.print();
        circleQueue.enqueue(7);
        circleQueue.enqueue(8);
        circleQueue.enqueue(9);
        circleQueue.enqueue(10);
        circleQueue.print();
        circleQueue.enqueue(11);
        circleQueue.print();
        circleQueue.enqueue(12);
        circleQueue.print();
        int dequeue2 = circleQueue.dequeue();
        System.out.println(dequeue2);
        circleQueue.print();
    }
}
class CircleQueue {
    int head = 0;
    int tail = 0;
    private int size = 10;
    private int numberOfEntries = 0;
    private int[] entries = new int[size];
    private final int SCALE_FACTOR = 2;

    public CircleQueue(int size){
        this.size = size;
        this.entries = new int[size];
    }

    public void enqueue(int data){
        if(numberOfEntries==size){
            Collections.rotate(Arrays.asList(entries), -head);
            head = 0;
            tail = numberOfEntries;
            entries = Arrays.copyOf(entries, numberOfEntries*SCALE_FACTOR);
            size = size*SCALE_FACTOR;
        }
        ++numberOfEntries;
        entries[tail] = data;
        tail = (tail+1)%size;
    }
    public int dequeue(){
        if(numberOfEntries > 0){
            --numberOfEntries;
            int entry = entries[head];
            head = (head+1)%size;
            return entry;
        }
        return -1;
    }
    public void print(){
        System.out.println(Arrays.toString(entries));
    }
}
