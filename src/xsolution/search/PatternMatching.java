package xsolution.search;

class PatternMatching {
    boolean doesMatch(String pattern, String value){
        if(pattern.length() == 0) return value.length()==0;

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';
        int size  = value.length();

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt =pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainLength = size -mainSize*countOfMain;
            if(countOfAlt == 0 || remainLength%countOfAlt == 0){
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainLength/countOfAlt;
                if(matches(pattern, value, mainSize, altSize, altIndex)){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean matches(String pattern, String value, int mainSize, int altSize, int firstAlt) {
        int strIndex = mainSize;
        for (int i = 1; i < pattern.length(); i++) {
            int size = pattern.charAt(i) == pattern.charAt(0) ? mainSize:altSize;
            int offset = pattern.charAt(i) == pattern.charAt(0)? 0 : firstAlt;
            if(! isEqual(value, offset, strIndex, size)){
                return false;
            }
            strIndex+=size;
        }
        return true;
    }

    private boolean isEqual(String value, int offset1, int offset2, int size) {
        for (int i = 0;i <size ; i++){
            if(value.charAt(offset1+i)!=value.charAt(offset2+i)){
                return false;
            }
        }
        return true;
    }

    private int countOf(String pattern, char mainChar) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i)==mainChar){
                count++;
            }
        }
        return count;
    }
}
