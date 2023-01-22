package dynamic;

class Poly {
    static int poly(int[][] cache , int n, int first){
        if(n == first) return 1;
        int ret = cache[n][first];

        if(ret!=-1) return ret;

        ret=0;
        for (int second = 1; second <= n-first ; second++) {
            int add = second + first -1 ;
            add *= poly(cache,n-first, second);
            ret += add;
        }
        return ret;
     }
}
