package search.leetcode.intervalschedule;

import java.util.Arrays;
import java.util.Comparator;

class IntervalSchedule {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,4},
                {3,6}
        };
        System.out.println(intervalSchedule(intervals));
    }
    static int intervalSchedule(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int smallestEnd = intervals[0][1];
        for(int[] interval : intervals){
            int start = interval[0];
            if(start >= smallestEnd){
                count++;
                smallestEnd = interval[1];
            }
        }
        return count;
    }
}
