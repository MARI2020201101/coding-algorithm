package search.findmissingelement;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

class FindMissingElement {
    static int BUCKET = 16;
    static int findMissingElement(List<Integer> list){
        int[] counter = new int[BUCKET];
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int idx = iter.next() >>> 16;
            counter[idx]++;
        }
        for (int i = 0; i < counter.length; i++) {
            if(counter[i] < BUCKET){
                BitSet bitVec = new BitSet(BUCKET);
                iter = list.iterator();
                while(iter.hasNext()){
                    int x = iter.next();
                    if(i == (x >>> 16)){
                        bitVec.set(x&(BUCKET-1));
                    }
                }
                for (int j = 0; j<(1<<16) ; j++){
                    if(! bitVec.get(j)){
                        return (i<<16) | j;
                    }
                }
            }
        }
        return -1;
    }
}
