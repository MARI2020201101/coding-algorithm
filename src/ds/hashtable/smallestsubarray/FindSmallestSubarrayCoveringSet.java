package ds.hashtable.smallestsubarray;

import ds.hashtable.Subarray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FindSmallestSubarrayCoveringSet {
    static Subarray findSmallestSubArray(List<String> paragraph, Set<String> keywords){
        Map<String, Integer> keywordsToCover = new HashMap<>();
        for (String keyword : keywords){
            keywordsToCover.put(keyword, keywordsToCover.containsKey(keyword)
                    ? keywordsToCover.get(keyword)+1 : 1);
        }
        Subarray result = new Subarray(-1,-1);
        int remainingToCover = keywords.size();
        for (int left = 0,right = 0; right < paragraph.size(); right++) {
            Integer keywordCount = keywordsToCover.get(paragraph.get(right));
            if(keywordCount>=0){
                --remainingToCover;
            }
            while(remainingToCover == 0){
                if((result.start == -1 && result.end == -1)
                        || right-left < result.end - result.start){
                    result.start = left;
                    result.end = right;
                }

            keywordCount = keywordsToCover.get(paragraph.get(left));
            if(keywordCount!=null){
                keywordsToCover.put(paragraph.get(left), ++keywordCount);
                if(keywordCount > 0 ){
                    ++remainingToCover;
                }
            }
            ++left;
            }
        }
        return result;
    }
}
