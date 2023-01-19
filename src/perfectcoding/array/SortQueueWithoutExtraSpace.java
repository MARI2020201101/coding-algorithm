package perfectcoding.array;

import java.util.Queue;

class SortQueueWithoutExtraSpace {
    static void sort(Queue<Integer> queue){
        if(queue == null || queue.size() < 2){return;}

        for (int i = 1; i <= queue.size(); i++) {
            moveMinToRear(queue, queue.size()-1);
        }
    }

    private static void moveMinToRear(Queue<Integer> queue, int sortIndex) {
        int minElement = Integer.MAX_VALUE;
        boolean flag = false;

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            int currElement = queue.peek();
            queue.poll();

            if(currElement <= minElement && i <= sortIndex){
                if(flag){
                    queue.add(minElement);
                }
                flag = true;
                minElement = currElement;
            }else{
                queue.add(currElement);
            }
        }
        queue.add(minElement);
    }
}
