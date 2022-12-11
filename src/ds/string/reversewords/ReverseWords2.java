package ds.string.reversewords;

class ReverseWords2 {
    public static void main(String[] args) {
        char[] chars = {'r','a','m',' ','i','s',' ','c','o','s','t','l','y'};
        reverseWords(chars);
    }
    static char[] reverseWords(char[] chars){
        int start = 0;
        int end = chars.length-1;
        reverse(chars, start, end);

        int word = 0;
        int lastWord = 0;
        while(lastWord < chars.length){
            while(lastWord < chars.length && chars[lastWord]!=' '){
                lastWord++;
            }
            reverse(chars, word, lastWord-1);
            word = lastWord+1;
            lastWord = lastWord+1;
        }

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
