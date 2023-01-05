package search.bitoperation;

class SwapBits {
    public static void main(String[] args) {
        int swapBits = swapBits(73, 1, 6);
        System.out.println(swapBits);
    }
    static int swapBits(int x, int i, int j){
        if(((x>>>i) & 1) != ((x>>>j)&1)){
            x^=(1L <<i | 1L <<j);
        }
        return x;
    }
}
