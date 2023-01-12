package perfectcoding.bitoperation;

import java.util.BitSet;

class UniqueNumber {
    public static void main(String[] args) {
        int[] arr = {51,14,14,51,98,7,14,98,51,98};
        System.out.println(unique(arr));
    }
    static int unique(int arr[]){
        int INT_SIZE = 32;
        int result = 0;
        for (int i = 0; i < INT_SIZE; i++) {
            int bit = 1 << i;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if((arr[j] & bit) != 0){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                result += bit;
            }
        }
        return result;
    }

    static void duplicate(int[] arr){
        int MAX_N = 32000;
        BitSet bitArr = new BitSet(MAX_N);
        for (int i = 0; i < arr.length; i++) {
            if(bitArr.get(arr[i])){
                System.out.println("duplicate num -> "+arr[i]);
            }else{
                bitArr.set(arr[i]);
            }
        }
    }
    static void findNonRepeatable(int[] arr){
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int setBitOne = xor & (-xor);

        int p = 0;
        int q = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & setBitOne) == 0){
                p ^= arr[i];
            }else{
                q ^= arr[i];
            }
        }
        System.out.println("find non repeat two number -> "+ p + " , "+ q);
    }
}
