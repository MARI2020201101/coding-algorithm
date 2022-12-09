package heap.arrayentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry {
    int value;
    int arrayId;

    public ArrayEntry(int value, int arrayId) {
        this.value = value;
        this.arrayId = arrayId;
    }
    static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrs){
        List<Iterator<Integer>> iters = new ArrayList<>();
        for (int i = 0; i < sortedArrs.size(); i++) {
            iters.add(sortedArrs.get(i).iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                sortedArrs.size(), (a,b)->b.value-a.value);

        for (int i = 0; i < sortedArrs.size(); i++) {
            if(iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while(! minHeap.isEmpty()){
            ArrayEntry head = minHeap.poll();
            result.add(head.value);
            if(iters.get(head.arrayId).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(head.arrayId).next(), head.arrayId));
            }
        }
        return result;
    }
}
