package dp.dp01.eggdrop;

class EggDrop {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(eggDrop(2,20));
    }
    static int eggDrop(int egg, int floor){
        if(floor == 1) return 1;
        if(egg == 1) return floor;

        for (int i = 1; i <= floor; i++) {
            res = Math.min(res,
            Math.max(eggDrop(egg-1,i-1) , eggDrop(egg, floor-i)))+1;
        }
        return res;
    }
}
