package ds.heap.arrayentry;


import java.util.*;

class ArrayEntry2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        List<Integer> list2 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> list3 = new ArrayList<>();
        list1.add(3);
        list1.add(6);
        list1.add(7);
        list1.add(9);
        list1.add(11);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        sort(lists).forEach(System.out::println);
    }
    static List<Integer> sort(List<List<Integer>> lists){
        List<Iterator<Integer>> iters = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            iters.add(lists.get(i).iterator());
        }//iterator 초기화
        PriorityQueue<ListEntry> minHeap = new PriorityQueue<>();

        for (int i = 0; i < iters.size(); i++) {
            if(iters.get(i).hasNext()){
                minHeap.add(new ListEntry(iters.get(i).next(),i));
            }

        } //일단 처음 1개씩은 넣어두고
        List<Integer> result = new ArrayList<>();
        while(! minHeap.isEmpty()){
            ListEntry arrayEntry = minHeap.poll();
            result.add(arrayEntry.value);

            if(iters.get(arrayEntry.arrayId).hasNext()){
                Integer value = iters.get(arrayEntry.arrayId).next();
                minHeap.add(new ListEntry(value, arrayEntry.arrayId));
            }
        }
        return result;
    }
}
class ListEntry implements Comparable<ListEntry>{
    int value;
    int arrayId;

    public ListEntry(int value, int arrayId) {
        this.value = value;
        this.arrayId = arrayId;
    }

    @Override
    public int compareTo(ListEntry o) {
        return this.value - o.value;
    }
}