package search.essential;

class RegExMatch {
    static boolean isMatch(String regex, String str){
        if(regex.startsWith("^")){
            return __isMatch(regex.substring(1), str);
        }
        for (int i = 0; i <= str.length(); i++) {
            if(__isMatch(regex, str.substring(i))) return true;
        }
        return false;
    }

    private static boolean __isMatch(String regex, String str) {
        if(regex.isEmpty()) return true;
        if("$".equals(regex)) return str.isEmpty();
        if(regex.length() >=2 && regex.charAt(1) == '*'){
            if(str.charAt(0) == regex.charAt(0) || regex.charAt(0) == '.'){
                for (int i = 0; i < str.length(); i++) {
                    if(__isMatch(regex, str.substring(i+1))) return true;
                }
            }
            return __isMatch(regex.substring(2), str);
        }
        if(!str.isEmpty() && (regex.charAt(0)=='.' || regex.charAt(0) == str.charAt(0))){
            return __isMatch(regex.substring(1), str.substring(1));
        }
        return false;
    }
}
