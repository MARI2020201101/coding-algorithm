package dp.maxa;

public class MaxA2 {
    public static void main(String[] args) {
        System.out.println(maxA(7,0,0));
    }
    static int maxA(int n, int copy, int aCount){
        if(n<=0) return aCount;
        int n1 = maxA(n - 1, copy, aCount + 1);
        int n2 = maxA(n - 1, copy, aCount + copy);
        int n3 = maxA(n - 2, copy + aCount, aCount);
        return Math.max(n3, Math.max(n1,n2));
    }
}
