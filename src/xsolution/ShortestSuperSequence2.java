package xsolution;

import java.util.*;

class ShortestSuperSequence2 {
    public static void main(String[] args) {
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        System.out.println(shortestSuperSequence(big,small));
    }
    static Range shortestSuperSequence(int[] big, int[] small){
        ArrayList<Queue<Integer>> locations = __shortestSuperSequence(big, small);
        return getShortestClosure(locations);
    }

    private static Range getShortestClosure(ArrayList<Queue<Integer>> locations) {
        Queue<HeapNode> queue = new PriorityQueue<>();
        for (int i = 0; i < locations.size(); i++) {
            queue.add(new HeapNode(i, locations.get(i).poll()));
        }
        int bestStart = -1;
        int bestEnd = -1;
        int max = -1;
        int min = 100;
        while (! queue.isEmpty()){
            HeapNode node = queue.poll();
            Queue<Integer> list = locations.get(node.queueIdx);
            queue.add(new HeapNode(node.queueIdx,list.poll()));
            if(max - node.location < bestEnd - bestStart){

            }
        }
        return null;
    }

    private static ArrayList<Queue<Integer>> __shortestSuperSequence(int[] big, int[] small) {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], new PriorityQueue<>());
        }
        for (int i = 0; i < big.length; i++) {
            if(map.containsKey(big[i])){
                Queue<Integer> queue = map.get(big[i]);
                queue.add(i);
            }
        }
        ArrayList<Queue<Integer>> locations = new ArrayList<>();
        for (Map.Entry<Integer, Queue<Integer>> queueEntry : map.entrySet()) {
            locations.add(queueEntry.getValue());
        }
        return locations;
    }
}
class HeapNode {
    int queueIdx;
    int location;

    public HeapNode(int queueIdx, int location) {
        this.queueIdx = queueIdx;
        this.location = location;
    }
}
