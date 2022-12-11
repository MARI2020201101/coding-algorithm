package ds.heap.median;

import java.util.*;

class Median {
    private static final int CAPACITY = 16;
    static List<Double> median(Iterator<Integer> list){
        //큰 절반, 작은 절반
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(CAPACITY, Comparator.reverseOrder());
        List<Double> result = new ArrayList<>();
        while(list.hasNext()){
            int x = list.next();
            minHeap.add(x);
            maxHeap.add(minHeap.remove());
            if(minHeap.size() < maxHeap.size()){
                minHeap.add(maxHeap.remove());
            }
            result.add(minHeap.size()%2 == 0 ? 0.5*(minHeap.peek() + maxHeap.peek()) : (double)minHeap.peek());
        }
        return result;
    }
}
