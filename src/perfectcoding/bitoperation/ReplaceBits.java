package perfectcoding.bitoperation;

class ReplaceBits {
    public static void main(String[] args) {
        System.out.println(sequence(339809));
        System.out.println(next(124376));
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
    static int next(int n){
        int x = n;
        int zeros = 0;
        int ones = 0;
        while(x != 0 && (x&1) == 0){
            zeros++;
            x>>>=1;
        }
        while((x&1)==1){
            ones++;
            x>>>=1;
        }
        int flipPoint = zeros + ones;
        int flip = 1 << flipPoint;
        n|=flip;
        n &=(-1<<flipPoint);
        n |= ((1 << ones) - 1);
        return n;
    }
    static int count(int p, int q){
        int count = 0;
        int xor = p ^ q;
        while(xor!=0){
            if(xor==1){
                count++;
                xor>>=1;
            }
        }
        return count;
    }

    static int rotate(int n, int k){
        int fallBits = n << k;
        int fallBitsShiftToRight = n >> (31-k);
        return fallBits | fallBitsShiftToRight;
    }
}
