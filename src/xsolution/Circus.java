package xsolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Circus {
    public static void main(String[] args) {
        List<WeightHeight> array = new ArrayList<>();
        array.add(new WeightHeight(65,100));
        array.add(new WeightHeight(70,150));
        array.add(new WeightHeight(56,90));
        array.add(new WeightHeight(75,190));
        array.add(new WeightHeight(60,95));
        array.add(new WeightHeight(68,110));

        List<WeightHeight> maxSequence = maxSequence(array);
        maxSequence.forEach(System.out::println);

    }
    static List<WeightHeight> maxSequence(List<WeightHeight> array){
        Collections.sort(array);
        return maxSequence(array, new ArrayList<>(), 0);
    }
    static List<WeightHeight> maxSequence(List<WeightHeight> array, List<WeightHeight> curr, int index){
        if(index >= array.size()){
            return new ArrayList<>(curr);
        }
        WeightHeight target = array.get(index);
        List<WeightHeight> maxWith = new ArrayList<>();
        if(canAppend(curr, target)){
            System.out.println("true");
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
    public String toString() {
        return "WeightHeight{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(WeightHeight o) {
        if(this.height != o.height){
            return this.height - o.height;
        }
        return this.weight - o.weight;
    }
}