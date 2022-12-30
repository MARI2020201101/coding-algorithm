package xsolution;

class CountTwo {
    public static void main(String[] args) {
        System.out.println(count(25));
    }
    static int count(int n){
        int len = String.valueOf(n).length();
        int result = 0;
        for (int d = 0; d < len; d++) {
            result += count(n, d);
        }
        return result;
    }
    static int count(int n, int digit){
        double digitPow = Math.pow(10, digit);
        double digitPow10 = digitPow * 10;
        int rightLeft = (int) (n%digitPow10);

        int roundDown = n - rightLeft;
        int roundUp = (int) (roundDown + digitPow10);
        int right = (int)(n%digitPow);
        int digitNum = (int) (n / digitPow);

        if(digitNum < 2){
            return roundDown/10;
        }else if(digitNum == 2){
            return roundDown/10 + right + 1;
        }else{
            return roundUp/10;
        }
    }
}
