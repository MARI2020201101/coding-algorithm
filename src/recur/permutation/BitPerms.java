package recur.permutation;

import java.util.ArrayList;
import java.util.List;

class BitPerms {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        List<List<Integer>> lists = create(arr.length);
//        lists.forEach(System.out::println);
        List<List<Integer>> lists = create(arr, arr.length);
        lists.forEach(System.out::println);
    }
    static List<List<Integer>> create(int n){
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            int x = i;
            List<Integer> list = new ArrayList<>();
            for (int j = n-1; j >= 0; j--) {
                int bit = 1 << j;
                if((x & bit)>=1){
                    list.add(1);
                }else{
                    list.add(0);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    static List<List<Integer>> create(int[] arr, int n){
        List<List<Integer>> lists = create(n);
        List<List<Integer>> results = new ArrayList<>();
        for(List<Integer> list : lists){
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < arr.length; i++){
                if(list.get(i)==1){
                    result.add(arr[i]);
                }
            }
            results.add(result);
        }

        return results;
    }
}
