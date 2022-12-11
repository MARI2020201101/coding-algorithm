package ds.hashtable.smallestsubarray;

import ds.hashtable.Subarray;

import java.util.*;

public class FindSmallestSubarrayCoveringSet3 {
    static Subarray findSmallestSubArray(List<String> paragraph, List<String> keywords){
        Map<String, Integer> keywordToIdx = new HashMap<>();
        List<Integer> latestOccurrence = new ArrayList<>(keywords.size());
        List<Integer> shortestSubArrayLength = new ArrayList<>(keywords.size());

        for (int i = 0; i < keywords.size(); i++) {
            latestOccurrence.add(-1);
            shortestSubArrayLength.add(Integer.MAX_VALUE);
            keywordToIdx.put(keywords.get(i), i);
        }

        int shortestDistance = Integer.MAX_VALUE;
        Subarray result = new Subarray(-1,-1);
        for (int i = 0; i < paragraph.size(); i++) {
            Integer keywordIdx = keywordToIdx.get(paragraph.get(i));
            if(keywordIdx!=null){
                if(keywordIdx == 0){
                    shortestSubArrayLength.set(0,1);
                }else if(shortestSubArrayLength.get(keywordIdx-1) != Integer.MAX_VALUE){
                    int distanceToPrevKeyword = i - latestOccurrence.get(keywordIdx-1);
                    shortestSubArrayLength.set(keywordIdx,
                            distanceToPrevKeyword + shortestSubArrayLength.get(keywordIdx-1));
                }
                latestOccurrence.set(keywordIdx, i);
            }
            if(keywordIdx == keywords.size()-1 &&
            shortestSubArrayLength.get(shortestSubArrayLength.size() -1) < shortestDistance){
                shortestDistance = shortestSubArrayLength.get(shortestSubArrayLength.size()-1);
                result.start = i - shortestSubArrayLength.get(shortestSubArrayLength.size()-1) +1;
                result.end = i;
            }
        }
        return result;
    }

}
