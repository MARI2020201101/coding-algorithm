package dynamic;

class Tiling {
    static int tiling(int width){
        if(width == 1) return 1;
        else if(width == 0) return 0;
        return tiling(width-1) + tiling(width-2);
    }
    static int asymmetric(int width){
        if(width%2 == 1){
            return (tiling(width) - tiling(width/2));
        }
        int ret = tiling(width/2);
        ret = (ret - tiling(width/2));
        ret = (ret - tiling(width/2-1));
        return ret;
    }
}
