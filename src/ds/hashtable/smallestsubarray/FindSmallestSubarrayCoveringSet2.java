package ds.hashtable.smallestsubarray;

import ds.hashtable.Subarray;

import java.util.*;

class FindSmallestSubarrayCoveringSet2 {
    static Subarray findSmallestSubArray(Iterator<String> iter, List<String> queryStrings){
        LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();
        for (String s : queryStrings){
            dict.put(s, null);
        }
        int numStrSoFar = 0;

        Subarray response = new Subarray(-1,-1);
        int idx = 0;
        while(iter.hasNext()){
            String s = iter.next();
            if(dict.containsKey(s)){
                Integer it = dict.get(s);
                if(it == null){
                    numStrSoFar++;
                }
                dict.remove(s);
                dict.put(s, idx);
            }

            if(numStrSoFar == queryStrings.size()){
                if((response.start == -1 && response.end ==-1)
                || idx - getValueFromEntry(dict) < response.end- response.start){
                    response.start = getValueFromEntry(dict);
                    response.end = idx;
                }
            }
            ++idx;
        }
        return response;
    }

    private static int getValueFromEntry(LinkedHashMap<String, Integer> dict) {

        int result = 0;
        for (Map.Entry<String, Integer> entries : dict.entrySet()){
            result = entries.getValue();
            break;
        }
        return result;
    }
}
