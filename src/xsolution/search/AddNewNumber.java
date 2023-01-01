package xsolution.search;

import java.util.Comparator;
import java.util.PriorityQueue;

class AddNewNumber {
    static void addNewNumber(int randomNumber){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        if(maxHeap.size() == minHeap.size()){
            if(randomNumber > minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(randomNumber);
            }else{
                maxHeap.add(randomNumber);
            }
        }else{
            if(randomNumber > minHeap.peek()){
                minHeap.add(randomNumber);
            }else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(randomNumber);
            }
        }
    }
}
