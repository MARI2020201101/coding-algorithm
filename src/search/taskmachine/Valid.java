package search.taskmachine;

class Valid {
    public static void main(String[] args) {
        int i = binarySearch(8);
        System.out.println(i);
    }
    static int binarySearch(int k){
        int x = 0;
        for (int offset = k; offset > 0 ; offset/=2) {
            while(! valid(x+offset, k)) x+=offset;
        }
        return x+1;
    }

    private static boolean valid(int x, int k) {
        return x > k;
    }
}
