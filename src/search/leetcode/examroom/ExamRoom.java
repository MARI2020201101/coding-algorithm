package search.leetcode.examroom;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class ExamRoom {
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private TreeSet<int[]> pq;
    private int N;
    public ExamRoom(int N){
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a,b)->{
            int distA = distance(a);
            int distB = distance(b);
            return distA-distB;
        });
        addExamSeats(new int[]{-1,N});
    }

    private void addExamSeats(int[] seats) {
        pq.add(seats);
        startMap.put(seats[0], seats);
        endMap.put(seats[1], seats);
    }
    private void removeExamSeats(int[] seats) {
        pq.remove(seats);
        startMap.remove(seats[0]);
        endMap.remove(seats[1]);
    }

    private int distance(int[] seats) {
        return seats[1] - seats[0] - 1;
    }

    public int seat(){
        int[] longest = pq.last();
        int start = longest[0];
        int end = longest[1];
        int seat;
        if(start == -1){
            seat = 0;
        }
        else if(end == N){
            seat = N-1;
        }
        else {
            seat = start + ((end-start)/2) ;
        }
        int[] left = new int[]{start, seat};
        int[] right = new int[]{seat, end};
        removeExamSeats(longest);
        addExamSeats(left);
        addExamSeats(right);
        return seat;
    }
    public void leave(int seat){
        int[] right = startMap.get(seat);
        int[] left = endMap.get(seat);
        int[] merged = new int[]{left[0], right[1]};
        removeExamSeats(left);
        removeExamSeats(right);
        addExamSeats(merged);
    }
}
