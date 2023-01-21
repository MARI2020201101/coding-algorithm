package perfectcoding.array;

class CutBar {
    static int solve(int[] height , int left, int right){
        if(left == right) return height[left];

        int mid = (left + right)/2;

        int result = Math.max(solve(height, left, mid), solve(height, mid+1, right));

        int low = mid;
        int high = mid +1;

        int currHeight = Math.min(height[low], height[high]);

        result = Math.max(result, currHeight * 2);

        while(left < low || high < right){
            if(high < right && (low == left || height[low-1] < height[high+1])){
                high++;
                currHeight = Math.min(currHeight, height[high]);
            }
            else{
                low--;
                currHeight  = Math.min(currHeight, height[low]);
            }
            result = Math.max(result, currHeight * (high - low + 1));
        }
        return result;
    }
}
