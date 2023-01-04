package thisiscodingtest.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MaxChangeSum {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(4);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(5);
        b.add(5);
        b.add(6);
        b.add(6);
        b.add(5);

        System.out.println(solve2(a, b, 3));
    }
    static int solve(int[] a, int[] b , int k){
        int max = Arrays.stream(b).max().getAsInt();
        for (int i = 0; i < k; i++) {
            int minIdx = 0;
            for (int j = 0; j < a.length; j++) {
                minIdx = a[minIdx] < a[j] ? minIdx : j;
            }
            a[minIdx] = max;
        }
        return Arrays.stream(a).sum();
    }
    static int solve2(List<Integer> a, List<Integer> b , int k){
        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            a.set(i, b.get(i));
        }
        return a.stream().reduce(0, (s1, s2) -> s1+s2);
    }
}
