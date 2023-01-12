package perfectcoding.bitoperation;

class ReplaceBits {
    public static void main(String[] args) {
        System.out.println(sequence(339809));
    }
    static int replace(int p, int q, int i, int j){
        int mask = (-1 << (j+1)) | ((1 << i) - 1);
        p = p & mask;
        q <<= i;
        return p | q;
    }
    static int sequence(int n){
        int x = n;
        int maxCount = 0;
        int currCount = 0;
        boolean flag = true;
        while(x!=0){
            if((x & 1) == 1){
                currCount+=1;
                flag = false;
            }else{
                currCount = (x & 2)==0 ? 0 : flag ? 0 : currCount+1;
                flag = true;
            }
            maxCount = Math.max(currCount, maxCount);
            x>>>=1;
        }
        return maxCount;
    }
}
