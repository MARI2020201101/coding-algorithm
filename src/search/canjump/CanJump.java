package search.canjump;

class CanJump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    static int canJump(int[] nums){
        int start = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == start){
                count++;
                start = max;
                System.out.println("start = "+start);
            }
        }
        return count;
    }
}
