package ds.greedy.largestrectangle;

import java.util.*;

class LargestRectangle {
    public static void main(String[] args) {
        List<Integer> heights = new ArrayList<>();
        init(heights);
        System.out.println(calculate(heights));
    }
    static void init(List<Integer> heights){
        heights.addAll(Arrays.asList(1,4,2,5,6,3,2,6,6,5,2,1,3));
    }
    static int calculate(List<Integer> heights){
        Deque<Integer> pillars = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.size(); i++) {
            while(! pillars.isEmpty() && isNewOrEndPillar(heights, i, pillars.peekFirst())){
                int height = heights.get(pillars.removeFirst());
                int width = pillars.isEmpty() ? i : i - pillars.peekFirst() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            pillars.addFirst(i);
        }
        return maxArea;
    }

    private static boolean isNewOrEndPillar(List<Integer> heights, int currIdx, Integer lastIdx) {
        System.out.println(String.format("currIdx=%d, lastIdx=%d",currIdx,lastIdx));
        return currIdx >= heights.size() || heights.get(currIdx) < heights.get(lastIdx);
    }
}
