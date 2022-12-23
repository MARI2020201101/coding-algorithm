package xsolution.search;

class GetMaxNative {
    static int flip(int bit){
        return 1^bit;
    }
    static int sign(int a){
        //양수 음수 판별
        return flip((a>>31) & 0x1);
    }
    static int getMaxNative(int a, int b){
        int k = sign(a-b);
        int q = flip(k);
        return a*k + b*q;
    }
}
