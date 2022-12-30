package xsolution;

import java.util.ArrayList;
import java.util.List;

class CircusV2 {
    static List<WeightHeight> maxSequence(List<WeightHeight> array){
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
                maxSequence = max(maxSequence, solution);
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
