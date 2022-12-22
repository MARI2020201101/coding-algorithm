package xsolution.bitoperation;

class GetNext {
    public static void main(String[] args) {
        System.out.println(getNext(13948));
        System.out.println(Integer.toBinaryString(13948));
        System.out.println(Integer.toBinaryString(14079));
    }
    static int getNext(int n){
        int x = n;
        int c0 = 0;
        int c1 = 0;
        int p = 0;
        while((x&1) == 0){
            c0++;
            x>>>=1;
        }
        while((x&1) == 1){
            c1++;
            x>>>=1;
        }
        p = c0+c1; //1로 바꿀인덱스
        int mask = 1 << p;
        n &= mask ;
        int oneMask = (1<<(c1-1))-1;

        n |= oneMask;
        return n ;
    }
}
