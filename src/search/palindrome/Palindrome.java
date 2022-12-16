package search.palindrome;

class Palindrome {
    public static void main(String[] args) {
        String str = "aacxycaa";
        System.out.println(palindrome(str));
        String str2 = "abacd";
        System.out.println(palindrome(str2));
    }
    static String palindrome(String str){
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            String cand1 = palindrome(str, i, i);
            String cand2 = palindrome(str, i, i+1);
            String cand = cand1.length() > cand2.length() ? cand1 : cand2;
            longest = cand.length() >  longest.length() ?  cand : longest;
        }
        return longest;
    }
    static String palindrome(String str, int left, int right){
        while(left >= 0 && right < str.length()
        && (str.charAt(left) == str.charAt(right))){
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }
}
