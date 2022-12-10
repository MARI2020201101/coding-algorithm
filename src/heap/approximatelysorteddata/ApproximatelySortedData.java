package heap.approximatelysorteddata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ApproximatelySortedData {
    static List<Integer> approximatelySortedData(List<Integer> list, int k){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k && list.iterator().hasNext(); i++) {
            queue.add(list.get(i));
        }
        while (! queue.isEmpty()){
            Integer data = queue.poll();
            result.add(data);
        }
        return result;
    }
}
