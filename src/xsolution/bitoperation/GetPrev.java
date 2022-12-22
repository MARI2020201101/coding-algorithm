package xsolution.bitoperation;

class GetPrev {
    public static void main(String[] args) {
        System.out.println(getPrev(10115));
    }
    static int getPrev(int n){
        int x = n;
        int c0 = 0;
        int c1 = 0;
        int p = 0;
        while((x&1)==1) {
            c1++;
            x>>>=1;
        }
        while((x&1)==0){
            c0++;
            x>>>=1;
        }
        p = c1+c0;
        int mask = 1 << (p+1);
        n &= mask;
        int a = (1<<p) - 1;
        int b = 1<<c0;
        int oneMask = a & b;
        n |= oneMask;
        return n;
    }
}
