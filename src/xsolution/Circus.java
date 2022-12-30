package xsolution;

import java.util.ArrayList;
import java.util.List;

class Circus {
    static List<WeightHeight> maxSequence(List<WeightHeight> array){
        return maxSequence(array, new ArrayList<>(), 0);
    }
    static List<WeightHeight> maxSequence(List<WeightHeight> array, List<WeightHeight> curr, int index){
        if(index == array.size()){
            return new ArrayList<>(curr);
        }
        WeightHeight target = array.get(index);
        List<WeightHeight> maxWith = new ArrayList<>();
        if(canAppend(curr, target)){
            ArrayList<WeightHeight> next = new ArrayList<>(curr);
            next.add(target);
            maxWith = maxSequence(array, next, index + 1);
        }
        List<WeightHeight> maxWithout = maxSequence(array, curr, index + 1);
        return max(maxWith, maxWithout);
    }

    private static boolean canAppend(List<WeightHeight> sequence, WeightHeight target) {
        if(sequence == null) return false;
        if(sequence.size() == 0) return true;
        WeightHeight lastOne = sequence.get(sequence.size() - 1);
        return target.height < lastOne.height && target.weight < lastOne.weight;
    }

    static List<WeightHeight> max(List<WeightHeight> list1, List<WeightHeight> list2){
        return list1.size() > list2.size() ? list1 : list2;
    }
}
class WeightHeight implements Comparable<WeightHeight>{
    int weight;
    int height;

    public WeightHeight(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(WeightHeight o) {
        if(this.height != o.height){
            return this.height - o.height;
        }
        return this.weight - o.weight;
    }
}