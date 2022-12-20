package search.binary.kthnum;

class KthNum {
    public static void main(String[] args) {
        System.out.println(solve(3,7));
    }
    static int solve(int n, int k){
        int right = n*n;
        int left = 1;
        while(left <= right){
            int mid = (left+right)/2;
            int count = countEqualsOrLowerNum(n, mid);
            if(count <= k){
                return mid +1;
            }else if(count > k){
                right = mid-1;
            }
        }
        return left;
    }

    private static int countEqualsOrLowerNum(int n, int mid) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            count += Math.min(mid/i, n);
        }
        System.out.println("count = "+count);
        return count;
    }
}
