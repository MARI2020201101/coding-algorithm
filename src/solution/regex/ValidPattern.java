package solution.regex;

class ValidPattern {
    static boolean isValidPattern(String regex, String pattern){
        if(regex.startsWith("^")){
            return isValidPattern(regex.substring(1), pattern);
        }

        for (int i = 0; i < pattern.length(); i++) {
            String part = pattern.substring(i);
            if(__isValidPattern(regex, part)){
                return true;
            }
        }
        return false;
    }
    static boolean __isValidPattern(String regex, String pattern){
        // ^ $
        // . 문자
        // *
        if(regex.isEmpty()){
            return true;
        }

        if(regex.endsWith("$")){
            return __isValidPattern(regex.substring(0,regex.length()-1), pattern);
        }

        //여러개 매칭하는 경우 & 0개 매칭하는 경우
        if(regex.length() >=2 && regex.charAt(1)=='*'){
            return __isValidPattern(regex, pattern.substring(1)) ||
                    __isValidPattern(regex.substring(2), pattern);
        }

        if(regex.charAt(0) == '.'){
            return __isValidPattern(regex.substring(1), pattern);
        }

        if(Character.isAlphabetic(regex.charAt(0)) && regex.charAt(0) == pattern.charAt(0)){
            return __isValidPattern(regex.substring(1), pattern.substring(1));
        }
        return false;
    }
}
