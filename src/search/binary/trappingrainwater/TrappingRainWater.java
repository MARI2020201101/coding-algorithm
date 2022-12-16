package search.binary.trappingrainwater;

class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,1,1,2,1};
        System.out.println(trappingRainWater(heights));
    }
    static int trappingRainWater(int[] heights){
        int left = 0;
        int right = heights.length-1;
        int leftMax = heights[0];
        int rightMax = heights[heights.length-1];
        int totalWater = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, heights[left]);
            rightMax = Math.max(rightMax, heights[right]);

            if(leftMax < rightMax){
                totalWater += (leftMax - heights[left]);
                left++;
            }else{
                totalWater+= (rightMax - heights[right]);
                right--;
            }
        }
        return totalWater;
    }
}
