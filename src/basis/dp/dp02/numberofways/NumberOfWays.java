package basis.dp.dp02.numberofways;

class NumberOfWays {
    public static void main(String[] args) {
        System.out.println(numberOfWays(8,4));
    }
    static int numberOfWays(int n, int m){
        if(n<m) return 0;
        if(n<=1) return 1;
        if(n>m && m==1) return n;
        return numberOfWays(n-1, m)+ numberOfWays(n-1,m-1);
    }
}
