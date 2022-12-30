package xsolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CircusV2 {
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
        List<WeightHeight>[] solutions = new List[array.size()];
        for (int i = 0; i < array.size(); i++) {
            solutions[i] = new ArrayList<>();
        }

        List<WeightHeight> maxSequence = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            List<WeightHeight> candi = maxSequence(array, solutions, i);
            maxSequence = max(maxSequence, candi);
        }
        return maxSequence;
    }
    static List<WeightHeight> maxSequence(List<WeightHeight> array, List<WeightHeight>[] solutions, int index){
        List<WeightHeight> maxSequence = new ArrayList<>();
        WeightHeight target = array.get(index);
        for (int i = 0; i < index; i++) {
            List<WeightHeight> sequence = solutions[i];
            if(canAppend(sequence, target)){
                ArrayList<WeightHeight> solution = new ArrayList<>(sequence);
                solution.add(target);
                maxSequence = new ArrayList<>(max(maxSequence, solution));
            }
        }
        return maxSequence;
    }

    private static boolean canAppend(List<WeightHeight> sequence, WeightHeight target) {
        if(sequence == null) return false;
        if(sequence.size() == 0) return true;
        WeightHeight lastOne = sequence.get(sequence.size() - 1);
        return target.height < lastOne.height && target.weight < lastOne.weight;
    }

    static List<WeightHeight> max(List<WeightHeight> list1, List<WeightHeight> list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        return list1.size() > list2.size() ? list1 : list2;
    }
}
