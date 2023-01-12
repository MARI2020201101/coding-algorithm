package perfectcoding.bitoperation;

class FindPosition {
    static int findPosition(int n){
        if(! isTwoPow(n)) return -1;

        int bitNo = 0;
        while(n!=0){
            bitNo++;
            n>>=1;
        }
        return bitNo;
    }
    static boolean isTwoPow(int n){
        return n > 0 && (n & (n-1)) == 0;
    }
}

