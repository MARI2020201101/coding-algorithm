package search.leetcode.minmax;

import java.util.List;

class MinMax {
    int min;
    int max;

    public MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
    static MinMax findMinmax(List<Integer> list){
        MinMax minMax = new MinMax(list.get(0), list.get(0));
        if(list.isEmpty()){
            return new MinMax(-1,-1);
        }
        else if(list.size() == 1){
            return minMax;
        }

        for(int i = 1; i < list.size() ; i++){
            minMax = new MinMax(
                    Math.min(minMax.min, list.get(i)),
                    Math.max(minMax.max, list.get(i))
            );
        }
        return minMax;
    }
}
