package xsolution.search;

class OperationWithout {
    static int negate(int n){
        int neg = 0;
        int newSign = n < 0 ? 1 :-1;
        while(n!=0){
            neg += newSign;
            n+= newSign;
        }
        return neg;
    }

    static int negate2(int n){
        int neg = 0;
        int newSign = n < 0 ? 1 : -1;
        int delta = newSign;
        while(n!=0){
            boolean differentSigns = (n + delta > 0) != (n > 0);
            if(n+delta!=0 && differentSigns){
                delta = newSign;//delta 가 너무 크므로 조정한다.
            }
            neg += delta;
            n+=delta;
            delta+=delta;
        }
        return neg;
    }
    static int minus(int a, int b){
        return a + negate(b);
    }
    static int multiply(int a, int b){
        if(a < b){
            return multiply(b, a);
        }
        int sum = 0;
        for(int i = abs(b); i > 0; i = minus(i,1)){
            sum += a;
        }
        if(b < 0){
            return negate(sum);
        }
        return sum;
    }
    static int divide(int a, int b){
        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while(product + absb <= absa){
            product += absb;
            x++;
        }
        if((a<0 && b<0) || (a>0 && b>0)){
            return x;
        }else return negate(x);
    }

    private static int abs(int n) {
        if(n < 0){
            return negate(n);
        }else{
            return n;
        }
    }
}
