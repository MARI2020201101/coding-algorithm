package xsolution.bitoperation;

class UpdateBits {
    public static void main(String[] args) {
        int result = updateBits(71, 12, 1, 4);
        System.out.println("result = "+result);
    }
    static int updateBits(int n, int m, int i, int j){
        int left = (1 << (j+1))-1;
        int right = 1 << i;
        int mask = ~(left & right);

        n&=mask;
        m<<=i;
        System.out.println(String.format("left=%d, right=%d,mask=%d, n=%d, m=%d",left,right,m,n,m));
        return n | m;
    }
}
