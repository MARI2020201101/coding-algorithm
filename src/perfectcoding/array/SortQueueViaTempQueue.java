package perfectcoding.array;

import java.util.ArrayDeque;
import java.util.Queue;

class SortQueueViaTempQueue {
    static void sort(Queue<Integer> queue){
        if(queue == null || queue.size() < 2){return;}

        Queue<Integer> extra = new ArrayDeque<>();
        int count = 0;
        boolean sorted =false;
        int queueSize = queue.size();
        int lastElement = queue.peek();

        while(! sorted){
            if(lastElement <= queue.peek()){
                lastElement = queue.poll();
                extra.add(lastElement);
            }else{
                queue.add(queue.poll());
            }
            count++;
            if(count != queueSize){
                continue;
            }

            if(extra.size() == queueSize){
                sorted = true;
            }

            while(extra.size() > 0){
                queue.add(extra.poll());
                lastElement = queue.peek();
            }
            count = 0;
        }
    }
}
