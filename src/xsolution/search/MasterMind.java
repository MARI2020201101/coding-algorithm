package xsolution.search;

class MasterMind {
    static int MAX_COLORS = 4;
    static int code(char c){
        switch (c){
            case 'B' : return 0;
            case 'G' : return 1;
            case 'R' : return 2;
            case 'Y' : return 3;
            default:return -1;
        }
    }
    Result estimate(String guess, String solution){
        if(guess.length()!=solution.length()) return null;

        Result res = new Result();
        int[] frequnces = new int[MAX_COLORS];
        for (int  i =0; i < guess.length() ; i++){
            if(guess.charAt(i) == solution.charAt(i)){
                res.hits++;
            }else{
                int code = code(solution.charAt(i));
                frequnces[code]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if(code >=0 && frequnces[code] > 0 && guess.charAt(i)!= solution.charAt(i)){
                res.pseudoHits++;
                frequnces[code]--;
            }
        }
        return res;

    }
}
class Result {
     int hits = 0;
     int pseudoHits = 0;
}