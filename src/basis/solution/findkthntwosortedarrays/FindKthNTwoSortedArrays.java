package basis.solution.findkthntwosortedarrays;

class FindKthNTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11,13,15};
        int[] b = {2,3,4,5,7,8,10,14};
        int k = 5;
        System.out.println(findKthNTwoSortedArrays(a,b,k));
    }
    static int findKthNTwoSortedArrays(int[] a, int[] b, int k){
        int bottom = 0;
        int top = k;
        int x = (bottom + (top-bottom)/2);
        while(true){
            int ax1 = a[x-1];
            int ax = a[x];
            int bx1 = b[k-x-1];
            int bx = b[k-x];

            if(ax1 > bx) x-=1;
            else if(ax < bx1) x+=1;
            else {
                System.out.println("ax1 = "+ax1 + ",bx1= "+bx1);
                return x;
            }
        }
    }
}
