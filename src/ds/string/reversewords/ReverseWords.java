package ds.string.reversewords;

class ReverseWords {
    public static void main(String[] args) {
        char[] chars = {'r','a','m',' ','i','s',' ','c','o','s','t','l','y'};
        reverseWords(chars);
    }
    static char[] reverseWords(char[] chars){
        //1. 전체뒤집기
        int start = 0;
        int end = chars.length-1;
        reverse(chars, start, end);
        //2.' '가 아닐경우 뒤집기
        System.out.println(chars);
        int word = 0;
        int lastWord = 0;
        while(chars[lastWord]!=' '){
            lastWord++;
        }
        reverse(chars, word, lastWord-1);
        System.out.println(chars);
        System.out.println(lastWord);
        word = lastWord+1;
        lastWord = lastWord+1;
        while(chars[lastWord]!=' '){
            lastWord++;
        }
        reverse(chars, word, lastWord-1);
        System.out.println(chars);
        word = lastWord+1;
        lastWord = lastWord+1;
        while(lastWord < chars.length && chars[lastWord]!=' '){
            lastWord++;
        }
        reverse(chars, word, lastWord-1);
        System.out.println(chars);
        return chars;
    }
    static void reverse(char[] chars, int start, int end){
        while(start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
