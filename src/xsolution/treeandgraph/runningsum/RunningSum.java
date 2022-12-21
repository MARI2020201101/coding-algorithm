package xsolution.treeandgraph.runningsum;

import java.util.HashMap;

class RunningSum {
    static int solve(int[] arr, int target, HashMap<Integer,Integer> map){
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if(runningSum == target) count++;
            int partialSum = target - runningSum;
            if(map.containsKey(partialSum)){
                count += map.get(partialSum);
            }
            putOrIncrease(map, runningSum);
        }
        return count;
    }

    private static void putOrIncrease(HashMap<Integer, Integer> map, int runningSum) {
        if(map.containsKey(runningSum)){
            Integer value = map.get(runningSum);
            map.put(runningSum, value+1);
        }else{
            map.put(runningSum, 1);
        }
    }
}
