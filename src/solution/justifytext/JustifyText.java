package solution.justifytext;

import java.util.ArrayList;
import java.util.List;

class JustifyText {
    static List<String> justifyText(List<String> words, int len){
        int currLineStart = 0;
        int numWordsCurrLine = 0;
        int curLineLength = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            numWordsCurrLine++;
            int lookaheadLineLength = curLineLength
                    + words.get(i).length()
                    + (numWordsCurrLine-1); //blank 의 최소 개수
            if(lookaheadLineLength == len){
                result.add(
                        joinALineWithBlank(words, currLineStart, i ,
                                i - currLineStart)
                );
                currLineStart = i+1;
                numWordsCurrLine = 0;
                curLineLength = 0;
            }else if(lookaheadLineLength > len){
                result.add(joinALineWithBlank(words, currLineStart, i-1,
                        len - curLineLength
                ));
                currLineStart = i;
                numWordsCurrLine = i;
                curLineLength = words.get(i).length();
            }else{
                curLineLength += words.get(i).length();
            }

            if(numWordsCurrLine > 0){
                StringBuffer sb = new StringBuffer(
                        joinALineWithBlank(words, currLineStart, words.size()-1, numWordsCurrLine-1)
                );
                for (int j = 0; j < len - curLineLength - (numWordsCurrLine-1); j++) {
                    sb.append(" ");
                }
                result.add(sb.toString());
            }
            return result;

        }
    }

    private static String joinALineWithBlank(List<String> words, int start, int end, int numBlanks) {
        int numWordsCurrLine = end - start +1;
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < end; i++) {
            sb.append(words.get(i));
            numWordsCurrLine--;
            int numCurrBlank = (int) Math.ceil(numBlanks/numWordsCurrLine);
            for (int j = 0; j < numCurrBlank; j++) {
                sb.append(" ");
            }
            numBlanks -= numCurrBlank;
        }
        sb.append(words.get(end));
        for (int i = 0; i < numBlanks; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
