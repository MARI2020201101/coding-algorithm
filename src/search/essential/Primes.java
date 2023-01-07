package search.essential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Primes {
    public static void main(String[] args) {
        System.out.println(getPrimes(30));
    }
    static List<Integer> getPrimes(int n){
        final int size = (int)Math.floor(0.5*(n-3)) + 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < size; i++) {
            if(isPrime.get(i)){
                int p = (i*2)+3;
                primes.add(p);
                for (long j = ((i*i*2) + (6*i) +3) ; j < size ; j+=p){
                    isPrime.set((int)j, false);
                }
            }
        }
        return primes;
    }
}
