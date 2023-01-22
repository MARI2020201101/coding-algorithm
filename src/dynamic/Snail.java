package dynamic;

class Snail {
    static int m;
    static int n;
    static int climb(int[] cache, int days, int climbed){
        if(days == m){
            return climbed >= n ? 1: 0;
        }
        int ret = cache[days];
        if(ret!=-1) return ret;
        return cache[days] = climb(cache, days+1, climbed+1) +
                climb(cache, days+1, climbed+2);
    }

    static double climb2(double[] cache, int days, int climbed){
        if(days == m){
            return climbed >= n ? 1: 0;
        }
        double ret = cache[days];
        if(ret!=-1) return ret;
        return cache[days] = 0.75 * climb2(cache, days+1, climbed+1) +
                0.25 * climb2(cache, days+1, climbed+2);
    }
}
