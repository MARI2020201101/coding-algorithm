package xsolution;

class FindMajorityNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9,5,9,5,5,5};
        System.out.println(findMajorityNumber(arr));
    }
    static int findMajorityNumber(int[] arr){
        int count = 1;
        int majority = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(count == 0){
                majority = arr[i];
            }
            if(majority == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }
}
