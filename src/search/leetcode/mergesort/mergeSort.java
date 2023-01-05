package search.leetcode.mergesort;

import java.util.Collections;
import java.util.List;
import java.util.Random;

class mergeSort {
    static int solve(List<Integer> list, int k){
        int left = 0;
        int right = list.size()-1;
        Random random = new Random(0);
        while(left <=right){
            int pivotIdx = random.nextInt(right - left + 1) + left;
            int nextPivot = partition(left, right, pivotIdx, list);
            if(nextPivot == k){
                return list.get(nextPivot);
            }else if(nextPivot < k){
                left = nextPivot+1;
            }else{
                right = nextPivot-1;
            }
        }
        return -1;
    }

    private static int partition(int left, int right, int pivotIdx, List<Integer> list) {
        Integer value = list.get(pivotIdx);
        Collections.swap(list, right, pivotIdx);
        int curr=left;
        for (int i = left; i < right; i++) {
            if(list.get(i) < value){
                Collections.swap(list, i, curr);
                ++curr;
            }
        }
        Collections.swap(list, curr, right);
        return curr;
    }
}
