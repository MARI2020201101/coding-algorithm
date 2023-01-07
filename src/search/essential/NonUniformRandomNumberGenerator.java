package search.essential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class NonUniformRandomNumberGenerator {
    static int nonUniformRandomNumberGenerator(List<Integer> values,
                                               List<Double> probabilities){
        List<Double> prefixSumOfProbabilities = new ArrayList<>();
        probabilities.stream().reduce(0.0, (left, right)-> {
            prefixSumOfProbabilities.add(left+right);
            return left+right;
        });
        Random random = new Random();
        final double uniform01 = random.nextDouble();
        int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
        if(it < 0){
            final int intervalIdx = Math.abs(it) - 1 ;
            return values.get(intervalIdx);
        }else{
            return values.get(it);
        }
    }
}
