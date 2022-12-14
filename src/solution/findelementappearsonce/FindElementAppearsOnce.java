package solution.findelementappearsonce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindElementAppearsOnce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(5);
        System.out.println(findElementAppearsOnce(list));
    }
    static int findElementAppearsOnce(List<Integer> list){
        int[] count = new int[32];
        for(int x : list){
            for (int i = 0; i < count.length; i++) {
//                while(x!=0){
                    count[i]+=(x & 1);
                    x>>=1;
//                }
            }
        }
        System.out.println(Arrays.toString(count));
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}
