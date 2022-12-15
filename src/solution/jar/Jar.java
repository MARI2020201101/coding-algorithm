package solution.jar;

class Jar {

    public static void main(String[] args) {
        Jar[] jars = {
                new Jar(170,180),
                new Jar(330,340),
                new Jar(190,210),
        };
        System.out.println(canMeter(jars, 900,910));
    }


    static boolean canMeter(Jar[] jars, int L, int H){
        if(L < 0 || H < 0 || L > H){
            return false;
        }
        for (int i = 0; i < jars.length; i++) {
            if((jars[i].low <= L && jars[i].high >= H)
                    || canMeter(jars, L - jars[i].low, H - jars[i].high)) {
                return true;
            }
        }
        return false;
    }

    int low;
    int high;

    public Jar(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

