package dynamic;

class PatternMatching {
    static String W;
    static String S;
    static boolean match(int[][] cache , int w, int s){
        int result = cache[w][s];
        if(result!=-1) return result == 1;

        while(s < S.length() && w < W.length() &&(
                W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))){
            w++;
            s++;
        }

        if(w == W.length()) return s == S.length();

        if(W.charAt(w) == '*'){
            for (int skip = 0 ; skip+s <= S.length() ; ++skip){
                if(match(cache, w+1, s+skip)){
                    cache[w][s] = 1;
                    return true;
                }
            }
        }
        return false;
    }
}
