package basis.dp.dp01.regex;

class Regex {
    static boolean isMatch(String str, String pattern){
        return isMatch(str, 0, pattern, 0);
    }
    static boolean isMatch(String str, int p1, String pattern, int p2){
        if(p2 == pattern.length()){
           return p1 == str.length();
        }
        if(p1 == str.length()){
            while(p2 < pattern.length()){
                if(pattern.charAt(p2+1)=='*') p2+=2;
                else return false;
            }
        }
        if(str.charAt(p1) == pattern.charAt(p2) || pattern.charAt(p2)=='.'){
            return isMatch(str, p1+1, pattern, p2+1);
        }else{

            if(p2+1 < pattern.length() && pattern.charAt(p2+1) == '*'){
                return isMatch(str, p1+1, pattern, p2);
            }else if(p2-1>=0 && pattern.charAt(p2)=='*' && pattern.charAt(p2-1) == str.charAt(p1)){
                while (str.charAt(p1) == str.charAt(p1+1)){
                    p1++;
                }
                return isMatch(str, p1+1, pattern, p2+1);
            }
            return false;
        }
    }
}
