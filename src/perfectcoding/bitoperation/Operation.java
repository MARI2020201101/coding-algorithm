package perfectcoding.bitoperation;

class Operation {
    static int add(int p, int q){
        int carry = p & q;
        int remain = p ^ q;
        while(carry!=0){

            carry = carry << 1;
            int tmp = remain ^ carry;
            carry = carry & remain;
            remain = tmp;

        }
        return remain;
    }
    static int multiply(int p, int q){
        int result = 0;
        while(q!=0){
            if((p&1) == 1){
                result += q;
            }
            q>>=1;
            p<<=1;
        }
        return result;
    }
    static int subtract(int p, int q){
        while(q!=0){
            int borrow = (~p) & q;
            p = p ^ q;
            q = borrow << 1;
        }
        return p;
    }
    static long divide(int p, int q){
        int MAX_BIT = 31;

        long sign = (p<0) ^ (q<0) ? -1 : 1;

        p = Math.abs(p);
        q = Math.abs(q);

        long tmp = 0;
        long quotient = 0;
        for (int i = MAX_BIT; i >=0 ; i--) {
            long halfdown = tmp + (p << i);
            if(halfdown <= 0){
                tmp = tmp + p << i;
                quotient = q | 1L <<i;
            }
        }
        return sign * quotient;
    }
}
