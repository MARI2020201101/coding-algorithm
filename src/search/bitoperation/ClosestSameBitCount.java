package search.bitoperation;

class ClosestSameBitCount {
    public static void main(String[] args) {
        System.out.println(closestSameBitCount(6));
    }
    static int closestSameBitCount(int n){
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; i++) {
            if(((n>>>i)&1) != ((n>>>(i+1))&1)){
                int mask = (int) ((1L << i) | (1L << (i + 1)));
                n^=mask;
            }
        }
        return n;
    }
}
