package basis.dp.dp01.regex;

public class Regex2 {
    public static void main(String[] args) {
        System.out.println(isMatch("zaaab",".a*b"));
        System.out.println(isMatch("cb",".a*b"));
    }
    static boolean isMatch(String str, String pattern){
        return isMatch(str, 0, pattern, 0);
    }

    private static boolean isMatch(String str, int p1, String pat, int p2) {
        if(p2==pat.length()){
            return p1==str.length();
        }
        if(p1==str.length()){
            for (; p2 < pat.length(); p2+=2) {
                if(pat.charAt(p2)!='*') return false;
            }
        }
        if(str.charAt(p1) == pat.charAt(p2) || pat.charAt(p2)=='.'){
            if(p2+1 < pat.length() && pat.charAt(p2+1)=='*'){
                return isMatch(str, p1, pat, p2+2) ||
                        isMatch(str, p1+1, pat, p2);
            }
            return isMatch(str, p1+1, pat, p2+1);
        }else{
            if(p2+1 < pat.length() && pat.charAt(p2+1)=='*'){
                return isMatch(str, p1, pat, p2+2);
            }
            return false;
        }

    }
}
