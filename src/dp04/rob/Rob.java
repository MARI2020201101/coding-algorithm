package dp04.rob;

class Rob {
    static int[] house = {2,1,7,9,3,1};

    public static void main(String[] args) {
        System.out.println(maxRob(house));
    }
    static int maxRob(int[] house){
        int maxRob = 0;
        int idx = 0;
        int minusOne = 0;
        int minusTwo = 0;
        while(idx<house.length){
            int plus = Math.max(house[idx]+minusTwo, minusOne);
            maxRob += plus;
            if(plus == minusOne){
                idx++;
            }else{
                idx+=2;
            }
        }
        return maxRob;
    }
}
