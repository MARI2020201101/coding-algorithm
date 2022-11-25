package string.removereplace;

class RemoveAndReplace {
    public static void main(String[] args) {
        char[] chars = {'a','c','d','b','b','c','a'};
        System.out.println(removeAndReplace(chars));
    }
    static char[] removeAndReplace(char[] chars){
        int writeIdx=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!='b'){
                chars[writeIdx++]=chars[i];
            }
        }
        System.out.println(chars);
        --writeIdx;
        int i = chars.length-1;
        while(i >= 0){
            if(chars[writeIdx]=='a'){
                chars[i--]='d';
                chars[i--]='d';
                writeIdx--;
            }else{
                chars[i--] = chars[writeIdx];
                writeIdx--;
            }
            System.out.println(chars);
        }
        return chars;
    }
}
