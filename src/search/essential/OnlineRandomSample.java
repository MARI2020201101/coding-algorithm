package search.essential;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class OnlineRandomSample {
    static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k){
        List<Integer> runningSample = new ArrayList<>(k);
        for (int i = 0; sequence.hasNext() && i < k; i++) {
            runningSample.add(sequence.next());
        }
        int numSeenSoFar = k;
        Random randIdxGen = new Random();
        while (sequence.hasNext()){
            Integer x = sequence.next();
            ++numSeenSoFar;
            final int idxToReplace = randIdxGen.nextInt(numSeenSoFar);
            if(idxToReplace < k){
                runningSample.set(idxToReplace, x);
            }
        }
        return runningSample;
    }
}
