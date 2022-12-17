package basis.solution.binarysearchunknownlength;

import java.util.ArrayList;
import java.util.List;

class BinarySearchUnknownLength {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-14);
        list.add(-10);
        list.add(-2);
        list.add(108);
        list.add(108);
        list.add(243);
        list.add(285);
        list.add(285);
        list.add(285);
        list.add(401);

        System.out.println(binarySearchUnknownLength(list, 285));
        System.out.println(binarySearchUnknownLength(list, 400));

    }
    static int binarySearchUnknownLength(List<Integer> list, int k){
        int p = 0;
        while(true){
            try{
                int i = 1 << p;
                if(list.get(i) == k) return i;
                else if(list.get(i) > k) break;
            }catch (Exception e){
                break;
            }
            p++;
        }
        int start = 1<< (p-1);
        int end = (1<<p)-1;
        while(start<=end){
            int mid = (start + end)/2;
            try{
                if(list.get(mid)==k) return mid;
                else if(list.get(mid) < k) start = mid+1;
                else end = mid-1;
            }catch (Exception e){
                end = mid-1;
            }
        }
        return -1;
    }
}
