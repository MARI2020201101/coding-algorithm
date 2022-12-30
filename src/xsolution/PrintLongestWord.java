package xsolution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class PrintLongestWord {
    public static void main(String[] args) {
        String[] arr = {
                "cat", "banana", "dog", "nana" , "walk", "walker", "dogwalker"
        };
        printLongestWord(arr);
    }
    static void printLongestWord(String[] arr){
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(canBuildRecurrsively(arr[i], true, map)){
                System.out.println(arr[i]);
                return;
            }
        }
    }

    private static boolean canBuildRecurrsively(String str, boolean isOriginal, HashMap<String, Boolean> map) {
        if(! isOriginal && map.get(str)){
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            String left = str.substring(0, i);
            String remain = str.substring(i);
            if(map.get(left)!= null && map.get(left) && canBuildRecurrsively(remain, false, map)){
                return true;
            }
        }
        map.put(str, false);
        return false;
    }
}
